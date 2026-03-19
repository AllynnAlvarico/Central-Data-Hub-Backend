package ie.nta.central_data_hub.repository;

import ie.nta.central_data_hub.domain.Contract;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data MongoDB repository for Contract domain model.
 */
@Repository
public interface ContractRepository extends MongoRepository<Contract, String> {

    /**
     * Find a contract by its business identifier (contractId).
     *
     * @param contractId the business contract identifier
     * @return Optional containing the Contract if found, empty otherwise
     */
    Optional<Contract> findByContractId(int contractId);

    /**
     * Find all contracts by their status (statusId).
     *
     * @param statusId the status identifier
     * @return list of contracts with the specified status
     */
    List<Contract> findByStatusId(int statusId);

    /**
     * Find all contracts associated with a specific entity.
     *
     * @param entityId the business entity identifier
     * @return list of contracts for the specified entity
     */
    List<Contract> findByEntityId(int entityId);

    /**
     * Find all contracts by their type.
     *
     * @param contractType the contract type
     * @return list of contracts with the specified type
     */
    List<Contract> findByContractType(String contractType);
}
