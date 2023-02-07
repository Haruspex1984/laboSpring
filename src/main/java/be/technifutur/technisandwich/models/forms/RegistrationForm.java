package be.technifutur.technisandwich.models.forms;

import be.technifutur.technisandwich.models.entities.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class RegistrationForm {

    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;

    public User toEntity(){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setRoles(Set.of("USER"));
        return user;

    }
}
