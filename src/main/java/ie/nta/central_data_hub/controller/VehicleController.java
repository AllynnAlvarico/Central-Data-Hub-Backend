package ie.nta.central_data_hub.controller;

import ie.nta.central_data_hub.domain.vehicle.Vehicle;
import ie.nta.central_data_hub.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/all")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleByBusinessId(@PathVariable long id) {
        return vehicleService.getVehicleByBusinessId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search/starts-with/{prefix}")
    public List<Vehicle> searchByRegistrationStartingWith(@PathVariable String prefix) {
        return vehicleService.searchByRegistrationStartingWith(prefix);
    }

    @GetMapping("/search/contains")
    public List<Vehicle> searchByRegistrationContaining(@RequestParam String keyword) {
        return vehicleService.searchByRegistrationContaining(keyword);
    }

    @GetMapping("/operator/{operatorId}")
    public List<Vehicle> getVehiclesByOperator(@PathVariable long operatorId) {
        return vehicleService.getVehiclesByOperator(operatorId);
    }
}
