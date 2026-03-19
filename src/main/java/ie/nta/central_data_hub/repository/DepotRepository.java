package ie.nta.central_data_hub.repository;

import ie.nta.central_data_hub.domain.Depot;
import ie.nta.central_data_hub.domain.Entity;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepotRepository extends MongoRepository<Depot, String> {

    @Query("{}")
    List<Depot> findAll();

    @Query("{ 'depot_code': ?0 }")
    Optional<Depot> findByDepotCode(String depot_code);

    @Query("{ 'depot_operator': ?0 }")
    Optional<Depot> findByDepotOperator(int depot_operator);

    @Query("{ 'location': { $regex: '?0', $options: 'i' } }")
    Optional<Depot> findByLocationContaining(String location);

    @Query("{ 'depot_name': { $regex: '?0', $options: 'i' } }")
    Optional<Depot> findByDepotNameContaining(String depot_name);

}
