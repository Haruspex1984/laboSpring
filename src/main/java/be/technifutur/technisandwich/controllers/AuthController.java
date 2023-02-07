package be.technifutur.technisandwich.controllers;

import be.technifutur.technisandwich.JWT.JWTHolderDTO;
import be.technifutur.technisandwich.models.forms.LoginForm;
import be.technifutur.technisandwich.models.forms.RegistrationForm;
import be.technifutur.technisandwich.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService service;
    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegistrationForm form) {
        service.register(form);
    }

    @PostMapping("/sign_in")
    public JWTHolderDTO login(@RequestBody @Valid LoginForm form){
        return service.login(form);
    }
}
