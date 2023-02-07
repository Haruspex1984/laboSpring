package be.technifutur.technisandwich.repositories;

import be.technifutur.technisandwich.models.entities.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SandwichRepository extends JpaRepository<Sandwich,Long> {
}
