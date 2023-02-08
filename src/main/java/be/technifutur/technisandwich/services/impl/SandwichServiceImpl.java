package be.technifutur.technisandwich.services.impl;

import be.technifutur.technisandwich.models.DTO.SandwichDTO;
import be.technifutur.technisandwich.models.entities.Sandwich;
import be.technifutur.technisandwich.models.entities.enums.Diet;
import be.technifutur.technisandwich.repositories.SandwichRepository;
import be.technifutur.technisandwich.services.SandwichService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Sandwich> getOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<SandwichDTO> findAllByDiet(Diet diet) {
        return repository.findAllByDiet(diet).stream().map(SandwichDTO::fromEntity).toList();
    }
}
