package be.technifutur.technisandwich.services.impl;

import be.technifutur.technisandwich.models.entities.User;
import be.technifutur.technisandwich.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;


    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;

    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return (User) repository.findByUsername(username).orElseThrow();
    }

}
