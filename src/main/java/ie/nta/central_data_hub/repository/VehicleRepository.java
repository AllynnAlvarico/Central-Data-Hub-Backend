package ie.nta.central_data_hub.repository;

import ie.nta.central_data_hub.domain.vehicle.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data MongoDB repository for Vehicle domain model.
 * Provides access to the "collection_vehicle" collection.
 */
@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {

    /**
     * Finds a vehicle by its unique business identifier.
     * @param vehicleId The business identifier.
     * @return Optional containing the found vehicle, or empty if not found.
     */
    @Query("{ 'vehicle_id': ?0 }")
    Optional<Vehicle> findByVehicleId(long vehicleId);

    /**
     * Finds a vehicle by its fleet number.
     * @param fleetNumber The fleet number assigned to the vehicle.
     * @return The vehicle if found, otherwise null.
     */
    @Query("{ 'fleet_number': ?0 }")
    Vehicle findByFleetNumber(String fleetNumber);

    /**
     * Finds vehicles where the registration number contains the given keyword.
     * @param keyword The keyword to search for (case-insensitive).
     * @return List of matching vehicles.
     */
    @Query("{ 'registration': { $regex: '?0', $options: 'i' } }")
    List<Vehicle> findByRegistrationContaining(String keyword);

    /**
     * Finds vehicles where the registration number starts with the given prefix.
     * @param prefix The prefix to search for (case-insensitive).
     * @return List of matching vehicles.
     */
    @Query("{ 'registration': { $regex: '^?0', $options: 'i' } }")
    List<Vehicle> findByRegistrationStartingWith(String prefix);

    /**
     * Finds all vehicles associated with a specific operator.
     * @param operatorId The identifier of the operator.
     * @return List of vehicles belonging to the operator.
     */
    List<Vehicle> findByOperator(long operatorId);

}
