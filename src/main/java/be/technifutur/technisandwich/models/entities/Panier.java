package be.technifutur.technisandwich.models.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id", nullable = false)
    private Long id;

    @ManyToMany
    @JoinTable(name = "basket_sandwiches",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "sandwich_id"))
    private Set<Sandwich> sandwiches = new LinkedHashSet<>();

    @OneToOne(mappedBy = "panier")
    private User user;

}
