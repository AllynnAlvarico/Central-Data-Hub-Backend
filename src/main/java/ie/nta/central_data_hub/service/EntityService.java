package ie.nta.central_data_hub.service;

import ie.nta.central_data_hub.domain.Entity;
import ie.nta.central_data_hub.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityService {

    @Autowired
    private EntityRepository entityRepository;

    public List<Entity> searchByNameStartingWith(String letter) {
        return entityRepository.findByNameStartingWith(letter);
    }

    public List<Entity> searchByNameContaining(String keyword) {
        return entityRepository.findByNameContaining(keyword);
    }
}