package ie.nta.central_data_hub.service;

import ie.nta.central_data_hub.domain.vehicle.Vehicle;
import ie.nta.central_data_hub.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleByFleetNumber(String fleetNumber) {
        return vehicleRepository.findByFleetNumber(fleetNumber);
    }

    public Optional<Vehicle> getVehicleByBusinessId(long vehicleId) {
        return vehicleRepository.findByVehicleId(vehicleId);
    }

    public List<Vehicle> searchByRegistrationStartingWith(String prefix) {
        return vehicleRepository.findByRegistrationStartingWith(prefix);
    }

    public List<Vehicle> searchByRegistrationContaining(String keyword) {
        return vehicleRepository.findByRegistrationContaining(keyword);
    }

    public List<Vehicle> getVehiclesByOperator(long operatorId) {
        return vehicleRepository.findByOperator(operatorId);
    }

    public int getVehicleCountByOperator(long operatorId) {
        return vehicleRepository.findByOperator(operatorId).size();
    }

    public int getVehicleTotalCount() {
        return (int) vehicleRepository.count();
    }
}
