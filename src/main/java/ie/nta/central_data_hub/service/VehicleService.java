package ie.nta.central_data_hub.service;

import ie.nta.central_data_hub.domain.vehicle.Vehicle;
import ie.nta.central_data_hub.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for Vehicle-related operations.
 * Coordinates data access via VehicleRepository.
 */
@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    /**
     * Retrieves all vehicles from the database.
     * @return List of all vehicles.
     */
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    /**
     * Retrieves a vehicle by its fleet number.
     * @param fleetNumber The fleet number to search for.
     * @return The vehicle if found, otherwise null.
     */
    public Vehicle getVehicleByFleetNumber(String fleetNumber) {
        return vehicleRepository.findByFleetNumber(fleetNumber);
    }

    /**
     * Retrieves a vehicle by its unique business identifier.
     * @param vehicleId The business identifier.
     * @return Optional containing the found vehicle, or empty if not found.
     */
    public Optional<Vehicle> getVehicleByBusinessId(long vehicleId) {
        return vehicleRepository.findByVehicleId(vehicleId);
    }

    /**
     * Searches for vehicles with registration numbers starting with a prefix.
     * @param prefix The prefix to search for.
     * @return List of matching vehicles.
     */
    public List<Vehicle> searchByRegistrationStartingWith(String prefix) {
        return vehicleRepository.findByRegistrationStartingWith(prefix);
    }

    /**
     * Searches for vehicles with registration numbers containing a keyword.
     * @param keyword The keyword to search for.
     * @return List of matching vehicles.
     */
    public List<Vehicle> searchByRegistrationContaining(String keyword) {
        return vehicleRepository.findByRegistrationContaining(keyword);
    }

    /**
     * Retrieves all vehicles associated with a specific operator.
     * @param operatorId The operator identifier.
     * @return List of vehicles belonging to the operator.
     */
    public List<Vehicle> getVehiclesByOperator(long operatorId) {
        return vehicleRepository.findByOperator(operatorId);
    }

    /**
     * Gets the count of vehicles associated with a specific operator.
     * @param operatorId The operator identifier.
     * @return The number of vehicles.
     */
    public int getVehicleCountByOperator(long operatorId) {
        return vehicleRepository.findByOperator(operatorId).size();
    }

    /**
     * Gets the total count of vehicles in the system.
     * @return The total number of vehicles.
     */
    public int getVehicleTotalCount() {
        return (int) vehicleRepository.count();
    }
}
