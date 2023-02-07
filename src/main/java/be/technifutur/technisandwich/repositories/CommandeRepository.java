package be.technifutur.technisandwich.repositories;

import be.technifutur.technisandwich.models.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
