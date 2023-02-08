package be.technifutur.technisandwich.controllers;

import be.technifutur.technisandwich.models.DTO.SandwichDTO;
import be.technifutur.technisandwich.models.entities.Sandwich;
import be.technifutur.technisandwich.models.entities.enums.Diet;
import be.technifutur.technisandwich.services.SandwichService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sandwich")
public class SandwichController {
    private final SandwichService service;

    public SandwichController(SandwichService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<SandwichDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/test")
    public void test(){
        System.out.println("TEST");
    }

    @GetMapping("/diet")
    public Map<Diet, List<SandwichDTO>> findAllByDiets(@RequestParam("diet") List<Diet> diets) {
        Map<Diet, List<SandwichDTO>> result = new HashMap<>();
        diets.forEach(diet -> result.put(diet, service.findAllByDiet(diet)));
        return result;
    }


}
