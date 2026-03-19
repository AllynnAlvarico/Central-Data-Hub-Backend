package ie.nta.central_data_hub.service;

import ie.nta.central_data_hub.domain.vehicle.VehicleModel;
import ie.nta.central_data_hub.repository.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for VehicleModel-related operations.
 * Coordinates data access via VehicleModelRepository.
 */
@Service
public class VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    /**
     * Retrieves all vehicle models.
     * @return List of all vehicle models.
     */
    public List<VehicleModel> getAllVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    /**
     * Retrieves a vehicle model by its unique business identifier.
     * @param id The business identifier.
     * @return Optional containing the found vehicle model, or empty if not found.
     */
    public Optional<VehicleModel> getVehicleModelByBusinessId(long id) {
        return vehicleModelRepository.findByVehicleModelId(id);
    }

    /**
     * Gets the total count of vehicle models in the system.
     * @return The total number of vehicle models.
     */
    public int getVehicleModelTotalCount() {
        return (int) vehicleModelRepository.count();
    }
}
