package ie.nta.central_data_hub.controller;

import ie.nta.central_data_hub.domain.Contract;
import ie.nta.central_data_hub.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Contract-related endpoints.
 */
@RestController
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    /**
     * Endpoint to retrieve all contracts.
     * @return List of all contracts.
     */
    @GetMapping("/all")
    public List<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    /**
     * Endpoint to retrieve a contract by its unique business identifier.
     * @param id The business identifier.
     * @return ResponseEntity containing the contract if found, or 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContractByBusinessId(@PathVariable int id) {
        return contractService.getContractByBusinessId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Endpoint to retrieve all contracts with a specific status.
     * @param statusId The status identifier.
     * @return List of matching contracts.
     */
    @GetMapping("/status/{statusId}")
    public List<Contract> getContractsByStatus(@PathVariable int statusId) {
        return contractService.getContractsByStatus(statusId);
    }

    /**
     * Endpoint to retrieve all contracts associated with a specific entity.
     * @param entityId The entity identifier.
     * @return List of matching contracts.
     */
    @GetMapping("/entity/{entityId}")
    public List<Contract> getContractsByEntity(@PathVariable int entityId) {
        return contractService.getContractsByEntity(entityId);
    }

    /**
     * Endpoint to retrieve all contracts of a specific type.
     * @param type The contract type.
     * @return List of matching contracts.
     */
    @GetMapping("/type")
    public List<Contract> getContractsByType(@RequestParam String type) {
        return contractService.getContractsByType(type);
    }

    /**
     * Endpoint to get the total count of contracts in the system.
     * @return The total number of contracts.
     */
    @GetMapping("/total-count")
    public long getContractTotalCount() {
        return contractService.getContractTotalCount();
    }
}
