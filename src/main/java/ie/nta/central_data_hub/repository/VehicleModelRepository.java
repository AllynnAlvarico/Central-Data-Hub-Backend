package ie.nta.central_data_hub.repository;

import ie.nta.central_data_hub.domain.vehicle.VehicleModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data MongoDB repository for VehicleModel domain model.
 * Provides access to the "collection_vehicle_model" collection.
 */
@Repository
public interface VehicleModelRepository extends MongoRepository<VehicleModel, String> {

    /**
     * Finds a vehicle model by its unique business identifier.
     * @param vehicleModelId The business identifier.
     * @return Optional containing the found vehicle model, or empty if not found.
     */
    Optional<VehicleModel> findByVehicleModelId(long vehicleModelId);
}
