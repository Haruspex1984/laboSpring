package be.technifutur.technisandwich.controllers;

import be.technifutur.technisandwich.models.DTO.SandwichDTO;
import be.technifutur.technisandwich.services.SandwichService;
import be.technifutur.technisandwich.services.impl.SandwichServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
