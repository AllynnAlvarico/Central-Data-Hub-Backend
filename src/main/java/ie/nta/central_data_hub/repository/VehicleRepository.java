package ie.nta.central_data_hub.repository;

import ie.nta.central_data_hub.domain.vehicle.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {

    @Query("{ 'vehicle_id': ?0 }")
    Optional<Vehicle> findByVehicleId(long vehicleId);

    @Query("{ 'registration': { $regex: '?0', $options: 'i' } }")
    List<Vehicle> findByRegistrationContaining(String keyword);

    @Query("{ 'registration': { $regex: '^?0', $options: 'i' } }")
    List<Vehicle> findByRegistrationStartingWith(String prefix);

    List<Vehicle> findByOperator(long operatorId);

}
