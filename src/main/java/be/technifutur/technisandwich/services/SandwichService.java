package be.technifutur.technisandwich.services;

import be.technifutur.technisandwich.models.DTO.SandwichDTO;
import be.technifutur.technisandwich.models.entities.Sandwich;
import be.technifutur.technisandwich.models.entities.enums.Diet;

import java.util.List;
import java.util.Optional;

public interface SandwichService {
    List<SandwichDTO> getAll();
    Optional<Sandwich> getOne(Long id);

    List<SandwichDTO> findAllByDiet(Diet diet);


}
