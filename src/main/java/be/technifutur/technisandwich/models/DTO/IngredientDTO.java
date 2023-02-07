package be.technifutur.technisandwich.models.DTO;

import be.technifutur.technisandwich.models.entities.Ingredient;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredientDTO {
    private String name;

    public static IngredientDTO fromEntity(Ingredient entity){
        if(entity == null){
            return null;
        }

        return IngredientDTO.builder().name(entity.getName()).build();
    }

}
