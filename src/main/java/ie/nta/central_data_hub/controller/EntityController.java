package ie.nta.central_data_hub.controller;

import ie.nta.central_data_hub.domain.Entity;
import ie.nta.central_data_hub.enums.RoleEntity;
import ie.nta.central_data_hub.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entities")
public class EntityController {

    @Autowired
    private EntityService entityService;

    @GetMapping
    public List<Entity> getAllEntities() {
        return entityService.getAllEntities();
    }

    @GetMapping("/search/starts-with/{prefix}")
    public List<Entity> searchByNameStartingWith(@PathVariable String prefix) {
        return entityService.searchByNameStartingWith(prefix);
    }

    @GetMapping("/search/contains")
    public List<Entity> searchByNameContaining(@RequestParam String keyword) {
        return entityService.searchByNameContaining(keyword);
    }

    @GetMapping("/operators")
    public List<Entity> getOperators() {
        return entityService.getEntitiesByRole(RoleEntity.OPERATOR);
    }

    @GetMapping("/manufacturers")
    public List<Entity> getManufacturers() {
        return entityService.getEntitiesByRole(RoleEntity.MANUFACTURER);
    }

    @GetMapping("/suppliers")
    public List<Entity> getSuppliers() {
        return entityService.getEntitiesByRole(RoleEntity.SUPPLIER);
    }
}