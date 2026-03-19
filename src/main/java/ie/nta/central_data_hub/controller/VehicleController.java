package ie.nta.central_data_hub.controller;

import ie.nta.central_data_hub.domain.vehicle.Vehicle;
import ie.nta.central_data_hub.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Vehicle-related endpoints.
 */
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    /**
     * Endpoint to retrieve all vehicles.
     * @return List of all vehicles.
     */
    @GetMapping("/all")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    /**
     * Endpoint to retrieve a vehicle by its unique business identifier.
     * @param id The business identifier.
     * @return ResponseEntity containing the vehicle if found, or 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleByBusinessId(@PathVariable long id) {
        return vehicleService.getVehicleByBusinessId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Endpoint to retrieve a vehicle by its fleet number.
     * @param fleetNumber The fleet number assigned to the vehicle.
     * @return ResponseEntity containing the vehicle if found, or 404 Not Found.
     */
    @GetMapping("/fleet/{fleetNumber}")
    public ResponseEntity<Vehicle> getVehicleByFleetNumber(@PathVariable String fleetNumber) {
        Vehicle vehicle = vehicleService.getVehicleByFleetNumber(fleetNumber);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint to search for vehicles where the registration starts with a prefix.
     * @param prefix The search prefix.
     * @return List of matching vehicles.
     */
    @GetMapping("/search/registration/starts-with/{prefix}")
    public List<Vehicle> searchByRegistrationStartingWith(@PathVariable String prefix) {
        return vehicleService.searchByRegistrationStartingWith(prefix);
    }

    /**
     * Endpoint to search for vehicles where the registration contains a keyword.
     * @param keyword The search keyword.
     * @return List of matching vehicles.
     */
    @GetMapping("/search/contains")
    public List<Vehicle> searchByRegistrationContaining(@RequestParam String keyword) {
        return vehicleService.searchByRegistrationContaining(keyword);
    }

    /**
     * Endpoint to retrieve all vehicles belonging to a specific operator.
     * @param operatorId The operator identifier.
     * @return List of vehicles.
     */
    @GetMapping("/operator/{operatorId}")
    public List<Vehicle> getVehiclesByOperator(@PathVariable long operatorId) {
        return vehicleService.getVehiclesByOperator(operatorId);
    }

    /**
     * Endpoint to get the count of vehicles belonging to a specific operator.
     * @param operatorId The operator identifier.
     * @return The number of vehicles.
     */
    @GetMapping("/operator/{operatorId}/count")
    public int getVehicleCountByOperator(@PathVariable long operatorId) {
        return vehicleService.getVehicleCountByOperator(operatorId);
    }

    /**
     * Endpoint to get the total count of vehicles in the system.
     * @return The total number of vehicles.
     */
    @GetMapping("/total-count")
    public int getVehicleTotalCount() {
        return vehicleService.getVehicleTotalCount();
    }
}
