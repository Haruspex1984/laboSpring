package be.technifutur.technisandwich.utils;

import be.technifutur.technisandwich.models.entities.Ingredient;
import be.technifutur.technisandwich.models.entities.Sandwich;
import be.technifutur.technisandwich.models.entities.User;
import be.technifutur.technisandwich.repositories.IngredientRepository;
import be.technifutur.technisandwich.repositories.SandwichRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
public class DataInit implements InitializingBean {


    private final IngredientRepository ingredientRepository;
    private final SandwichRepository sandwichRepository;

    public DataInit(IngredientRepository ingredientRepository, SandwichRepository sandwichRepository) {
        this.ingredientRepository = ingredientRepository;
        this.sandwichRepository = sandwichRepository;
    }

    @Override
    @Transactional
    public void afterPropertiesSet() throws Exception {

        Sandwich sandwich = new Sandwich();
        sandwich.setName("Yunusau");
        sandwich.setDescription("Le famille Yunusau transmet la recette de ce sandwich de génération en génération");
        sandwich.setPrice(5.5);
        Set<Ingredient> ingredients = new HashSet<>();

        Ingredient ingredient = new Ingredient();
        ingredient.setName("Poulet");
        ingredients.add(ingredient);
        ingredientRepository.save(ingredient);

        ingredient = new Ingredient();
        ingredient.setName("Crudités");
        ingredients.add(ingredient);
        ingredientRepository.save(ingredient);

        ingredient = new Ingredient();
        ingredient.setName("Sauce Yunusau");
        ingredients.add(ingredient);
        ingredientRepository.save(ingredient);

        sandwich.setIngredients(ingredients);
        sandwichRepository.save(sandwich);

    }
}
