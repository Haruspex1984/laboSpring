package be.technifutur.technisandwich.services;

import be.technifutur.technisandwich.JWT.JWTHolderDTO;
import be.technifutur.technisandwich.models.forms.LoginForm;
import be.technifutur.technisandwich.models.forms.RegistrationForm;

public interface AuthService {
    void register(RegistrationForm form);
    JWTHolderDTO login(LoginForm form);
}
