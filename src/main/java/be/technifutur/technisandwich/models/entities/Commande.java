package be.technifutur.technisandwich.models.entities;

import be.technifutur.technisandwich.models.entities.enums.State;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Commande{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long id;

    @Column(nullable = false,name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @Column(nullable = false)
    private State state;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "commande_sandwiches",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "sandwich_id"))
    private Set<Sandwich> sandwiches = new LinkedHashSet<>();

}
