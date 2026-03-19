package ie.nta.central_data_hub.repository;

import ie.nta.central_data_hub.domain.Entity;
import ie.nta.central_data_hub.domain.vehicle.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends MongoRepository<Entity, String> {

    @Query("{ 'vehicle_id': ?0 }")
    Vehicle findByVehicleId(String vehicleId);

}
