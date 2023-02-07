package be.technifutur.technisandwich.models.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Sandwich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sandwich_id", nullable = false)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    @ManyToMany(mappedBy = "sandwiches")
    private Set<Panier> paniers = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "sandwich_ingredients",
            joinColumns = @JoinColumn(name = "sandwich_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> ingredients = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "sandwich_diets",
            joinColumns = @JoinColumn(name = "sandwich_id"),
            inverseJoinColumns = @JoinColumn(name = "diet_id"))
    private Set<Diet> diets = new LinkedHashSet<>();





}
