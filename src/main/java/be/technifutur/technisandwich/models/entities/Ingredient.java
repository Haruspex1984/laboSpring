package be.technifutur.technisandwich.models.entities;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Ingredient {

    public Ingredient(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Sandwich> sandwiches = new LinkedHashSet<>();

    public Ingredient() {

    }
}
