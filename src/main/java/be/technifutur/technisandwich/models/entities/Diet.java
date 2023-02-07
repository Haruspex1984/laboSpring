package be.technifutur.technisandwich.models.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diet_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String description;

    @ManyToMany(mappedBy = "diets")
    private Set<Sandwich> sandwiches = new LinkedHashSet<>();

}
