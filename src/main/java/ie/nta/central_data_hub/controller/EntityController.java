package ie.nta.central_data_hub.controller;

import ie.nta.central_data_hub.domain.Entity;
import ie.nta.central_data_hub.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class EntityController {

    @Autowired
    private EntityService entityService;

    @GetMapping("/starts-with/{prefix}")
    public List<Entity> searchByNameStartingWith(@RequestParam String letter) {
        return entityService.searchByNameStartingWith(letter);
    }

    @GetMapping("/search/contains")
    public List<Entity> searchByNameContaining(@RequestParam String keyword) {
        return entityService.searchByNameContaining(keyword);
    }
}