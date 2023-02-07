package be.technifutur.technisandwich.repositories;

import be.technifutur.technisandwich.models.entities.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietRepository extends JpaRepository<Diet,Long> {
}
