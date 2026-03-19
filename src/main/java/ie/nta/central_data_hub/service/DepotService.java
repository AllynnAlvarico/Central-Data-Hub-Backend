package ie.nta.central_data_hub.service;

import ie.nta.central_data_hub.domain.Depot;
import ie.nta.central_data_hub.domain.Entity;
import ie.nta.central_data_hub.repository.DepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepotService {

    @Autowired
    private DepotRepository depotRepository;

    public List<Depot> getAllDepots() {
        return depotRepository.findAll();
    }

    public Depot getDepotByCode(String depotCode) {
        return depotRepository.findByDepotCode(depotCode).orElse(null);
    }

    public Depot getDepotByOperator(int depotOperator) {
        return depotRepository.findByDepotOperator(depotOperator).orElse(null);
    }

    public Depot getDepotByLocation(String location) {
        return depotRepository.findByLocationContaining(location).orElse(null);
    }

    public Depot getDepotByName(String depotName) {
        return depotRepository.findByDepotNameContaining(depotName).orElse(null);
    }

}
