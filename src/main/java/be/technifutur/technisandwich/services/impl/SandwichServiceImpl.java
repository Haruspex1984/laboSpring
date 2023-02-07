package be.technifutur.technisandwich.services.impl;

import be.technifutur.technisandwich.models.DTO.SandwichDTO;
import be.technifutur.technisandwich.models.entities.Sandwich;
import be.technifutur.technisandwich.repositories.SandwichRepository;
import be.technifutur.technisandwich.services.SandwichService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SandwichServiceImpl implements SandwichService {

    private final SandwichRepository repository;

    public SandwichServiceImpl(SandwichRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SandwichDTO> getAll() {
        return repository.findAll().stream().map(SandwichDTO::fromEntity).toList();
    }

    @Override
    public Sandwich getOne(Long id) {
        return null;
    }
}
