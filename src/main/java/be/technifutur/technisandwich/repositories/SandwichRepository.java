package be.technifutur.technisandwich.repositories;

import be.technifutur.technisandwich.models.entities.Sandwich;
import be.technifutur.technisandwich.models.entities.enums.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SandwichRepository extends JpaRepository<Sandwich,Long> {

    List<Sandwich> findAllByDiet(Diet diet);
}
