package ie.nta.central_data_hub.service;

import ie.nta.central_data_hub.domain.Entity;
import ie.nta.central_data_hub.domain.assignment.EntityRole;
import ie.nta.central_data_hub.enums.RoleEntity;
import ie.nta.central_data_hub.repository.EntityRepository;
import ie.nta.central_data_hub.repository.EntityRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntityService {

    @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private EntityRoleRepository entityRoleRepository;

    public List<Entity> searchByNameStartingWith(String letter) {
        return entityRepository.findByNameStartingWith(letter);
    }

    public List<Entity> searchByNameContaining(String keyword) {
        return entityRepository.findByNameContaining(keyword);
    }

    public List<Entity> getAllEntities() {
        return entityRepository.findAll();
    }

    /**
     * Retrieves all entities assigned to a specific role.
     *
     * @param role the role to filter by
     * @return list of entities with the specified role
     */
    public List<Entity> getEntitiesByRole(RoleEntity role) {
        List<EntityRole> associations = entityRoleRepository.findByEntityRoleId(role.getId());
        
        List<Long> entityIds = associations.stream()
                .map(EntityRole::getEntityId)
                .collect(Collectors.toList());
                
        return entityRepository.findAll().stream()
                .filter(entity -> entityIds.contains(entity.getEntityId()))
                .collect(Collectors.toList());
    }
}