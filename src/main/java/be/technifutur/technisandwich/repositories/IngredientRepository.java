package be.technifutur.technisandwich.repositories;

import be.technifutur.technisandwich.models.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

    public Ingredient findByName(String name);
}
