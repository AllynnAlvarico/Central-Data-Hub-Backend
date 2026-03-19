package ie.nta.central_data_hub.service;

import ie.nta.central_data_hub.domain.Contract;
import ie.nta.central_data_hub.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for Contract-related operations.
 * Coordinates data access via ContractRepository.
 */
@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    /**
     * Retrieves all contracts from the database.
     * @return List of all contracts.
     */
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    /**
     * Retrieves a contract by its unique business identifier.
     * @param contractId The business identifier.
     * @return Optional containing the found contract, or empty if not found.
     */
    public Optional<Contract> getContractByBusinessId(int contractId) {
        return contractRepository.findByContractId(contractId);
    }

    /**
     * Retrieves all contracts with a specific status.
     * @param statusId The status identifier.
     * @return List of matching contracts.
     */
    public List<Contract> getContractsByStatus(int statusId) {
        return contractRepository.findByStatusId(statusId);
    }

    /**
     * Retrieves all contracts associated with a specific entity.
     * @param entityId The entity identifier.
     * @return List of matching contracts.
     */
    public List<Contract> getContractsByEntity(int entityId) {
        return contractRepository.findByEntityId(entityId);
    }

    /**
     * Retrieves all contracts of a specific type.
     * @param contractType The type of contract.
     * @return List of matching contracts.
     */
    public List<Contract> getContractsByType(String contractType) {
        return contractRepository.findByContractType(contractType);
    }

    /**
     * Gets the total count of contracts in the system.
     * @return The total number of contracts.
     */
    public long getContractTotalCount() {
        return contractRepository.count();
    }
}
