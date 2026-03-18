package ie.nta.central_data_hub.repository;

import ie.nta.central_data_hub.domain.assignment.EntityRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data MongoDB repository for EntityRole association model.
 */
@Repository
public interface EntityRoleRepository extends MongoRepository<EntityRole, String> {

    /**
     * Find all entity-role associations for a specific role.
     *
     * @param entityRoleId the role identifier
     * @return list of EntityRole associations
     */
    List<EntityRole> findByEntityRoleId(int entityRoleId);

    /**
     * Find all roles assigned to a specific entity.
     *
     * @param entityId the business entity identifier
     * @return list of EntityRole associations
     */
    List<EntityRole> findByEntityId(long entityId);
}
