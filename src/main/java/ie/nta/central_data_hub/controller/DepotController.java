package ie.nta.central_data_hub.controller;

import ie.nta.central_data_hub.domain.Depot;
import ie.nta.central_data_hub.service.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/depots")
public class DepotController {

    @Autowired
    private DepotService depotService;

    @GetMapping("/all")
    public List<Depot> getAllDepots() {
        return depotService.getAllDepots();
    }

    @GetMapping("/code/{depotCode}")
    public Depot getDepotByCode(@PathVariable String depotCode) {
        return depotService.getDepotByCode(depotCode);
    }

    @GetMapping("/operator/{depotOperator}")
    public Depot getDepotByOperator(@PathVariable String depotOperator) {
        return depotService.getDepotByOperator(Integer.parseInt(depotOperator));
    }

    @GetMapping("/location/{location}")
    public Depot getDepotByLocation(@PathVariable String location) {
        return depotService.getDepotByLocation(location);
    }

    @GetMapping("/name/{depotName}")
    public Depot getDepotByName( @PathVariable String depotName) {
        return depotService.getDepotByName(depotName);
    }

}
