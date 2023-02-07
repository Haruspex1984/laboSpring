package be.technifutur.technisandwich.services;

import be.technifutur.technisandwich.models.DTO.SandwichDTO;
import be.technifutur.technisandwich.models.entities.Sandwich;

import java.util.List;

public interface SandwichService {
    List<SandwichDTO> getAll();
    Sandwich getOne(Long id);
}
