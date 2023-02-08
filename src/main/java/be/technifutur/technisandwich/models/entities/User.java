package be.technifutur.technisandwich.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "\"user\"")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private boolean enabled = true;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Commande> orders = new LinkedHashSet<>();

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "basket_id")
    private Panier panier;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role)).toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
