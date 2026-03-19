package ie.nta.central_data_hub.repository;

import ie.nta.central_data_hub.domain.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data MongoDB repository for Entity domain model.
 * Provides standard CRUD operations and custom query methods for Entity persistence.
 */
@Repository
public interface EntityRepository extends MongoRepository<Entity, String> {

    /**
     * Find an entity by its business identifier (entityId).
     *
     * @param entityId the business entity identifier
     * @return Optional containing the Entity if found, empty otherwise
     */
    Optional<Entity> findByEntityId(long entityId);

    /**
     * Find all entities by their status (statusId).
     *
     * @param statusId the status identifier (1=ACTIVE, 2=INACTIVE, 3=SUSPENDED)
     * @return list of entities with the specified status
     */
    List<Entity> findByStatusId(int statusId);

    /**
     * Find an entity by its country.
     *
     * @param country the country name
     * @return list of entities operating in the specified country
     */
    List<Entity> findByCountry(String country);

    /**
     * Check if an entity with the given entityId already exists.
     *
     * @param entityId the business entity identifier
     * @return true if entity exists, false otherwise
     */
    boolean existsByEntityId(long entityId);

    // Search for entities containing the given keyword in their name (case-insensitive)
    @Query("{ 'entity_name': { $regex: '?0', $options: 'i' } }")
    List<Entity> findByNameContaining(String keyword);

    // Search for entities where the name starts with the given letter (case-insensitive)
    @Query("{ 'entity_name': { $regex: '^?0', $options: 'i' } }")
    List<Entity> findByNameStartingWith(String letter);

}

