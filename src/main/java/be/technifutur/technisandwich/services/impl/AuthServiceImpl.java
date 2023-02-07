package be.technifutur.technisandwich.services.impl;

import be.technifutur.technisandwich.JWT.JWTHolderDTO;
import be.technifutur.technisandwich.JWT.JWTProvider;
import be.technifutur.technisandwich.models.entities.User;
import be.technifutur.technisandwich.models.forms.LoginForm;
import be.technifutur.technisandwich.models.forms.RegistrationForm;
import be.technifutur.technisandwich.repositories.UserRepository;
import be.technifutur.technisandwich.services.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JWTProvider provider;

    public AuthServiceImpl(UserRepository repository, PasswordEncoder encoder, AuthenticationManager authManager, JWTProvider provider) {
        this.repository = repository;
        this.encoder = encoder;
        this.authManager = authManager;
        this.provider = provider;

    }

    @Override
    public void register(RegistrationForm form) {
        if (repository.existsByUsername(form.getUsername())) {
            throw new RuntimeException("Username not available");
        }

        User user = form.toEntity();
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);

    }

    @Override
    public JWTHolderDTO login(LoginForm form) {
        Authentication auth = new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword());
        auth = authManager.authenticate(auth);
        String token = provider.createToken(auth);

        JWTHolderDTO tokenHolder = new JWTHolderDTO(token);

        return tokenHolder;
    }
}
