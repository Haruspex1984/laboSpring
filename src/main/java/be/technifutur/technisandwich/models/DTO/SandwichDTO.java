package be.technifutur.technisandwich.models.DTO;

import be.technifutur.technisandwich.models.entities.Ingredient;
import be.technifutur.technisandwich.models.entities.Sandwich;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class SandwichDTO {


    private String name;
    private String description;
    private double price;
    private List<IngredientDTO> ingredients;

    public static SandwichDTO fromEntity(Sandwich entity){
        if (entity == null) {
            return null;
        }

        return SandwichDTO.builder()
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .ingredients(entity.getIngredients().stream().map(IngredientDTO::fromEntity).toList())
                .build();

    }

}
