package ie.nta.central_data_hub.controller;

import ie.nta.central_data_hub.domain.vehicle.VehicleModel;
import ie.nta.central_data_hub.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for VehicleModel-related endpoints.
 */
@RestController
@RequestMapping("/vehicle-models")
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;

    /**
     * Endpoint to retrieve all vehicle models.
     * @return List of all vehicle models.
     */
    @GetMapping("/all")
    public List<VehicleModel> getAllVehicleModels() {
        return vehicleModelService.getAllVehicleModels();
    }

    /**
     * Endpoint to retrieve a vehicle model by its unique business identifier.
     * @param id The business identifier.
     * @return ResponseEntity containing the vehicle model if found, or 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<VehicleModel> getVehicleModelByBusinessId(@PathVariable long id) {
        return vehicleModelService.getVehicleModelByBusinessId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Endpoint to get the total count of vehicle models in the system.
     * @return The total number of vehicle models.
     */
    @GetMapping("/total-count")
    public int getVehicleModelTotalCount() {
        return vehicleModelService.getVehicleModelTotalCount();
    }
}
