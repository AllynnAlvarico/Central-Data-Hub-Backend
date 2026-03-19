package ie.nta.central_data_hub.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

/**
 * Contract domain model representing service contracts between entities.
 * Maps to the "collection_contract" MongoDB collection.
 */
@Document(collection = "collection_contract")
public class Contract {

    /**
     * MongoDB document identifier.
     */
    @Id
    private String id;

    /**
     * Business identifier for the contract.
     */
    @Field("contract_id")
    private int contractId;

    /**
     * Contract abbreviation or code.
     */
    @Field("contract_abbr")
    private String contractAbbr;

    /**
     * Full name of the contract.
     */
    @Field("contract_name")
    private String contractName;

    /**
     * Identifier of the entity associated with this contract.
     */
    @Field("entity_id")
    private int entityId;

    /**
     * Type of contract.
     */
    @Field("contract_type")
    private String contractType;

    /**
     * Status identifier mapping to StatusContract enum.
     */
    @Field("status_id")
    private int statusId;

    public Contract() {
    }

    public Contract(int contractId, String contractAbbr, String contractName, int entityId, String contractType, int statusId) {
        this.contractId = contractId;
        this.contractAbbr = contractAbbr;
        this.contractName = contractName;
        this.entityId = entityId;
        this.contractType = contractType;
        this.statusId = statusId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public void setContractAbbr(String contractAbbr) {
        this.contractAbbr = contractAbbr;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getContractId() {
        return contractId;
    }

    public String getContractAbbr() {
        return contractAbbr;
    }

    public String getContractName() {
        return contractName;
    }

    public int getEntityId() {
        return entityId;
    }

    public String getContractType() {
        return contractType;
    }

    public int getStatusId() {
        return statusId;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id='" + id + '\'' +
                ", contractId=" + contractId +
                ", contractAbbr='" + contractAbbr + '\'' +
                ", contractName='" + contractName + '\'' +
                ", entityId=" + entityId +
                ", contractType='" + contractType + '\'' +
                ", statusId=" + statusId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return contractId == contract.contractId &&
                entityId == contract.entityId &&
                statusId == contract.statusId &&
                Objects.equals(id, contract.id) &&
                Objects.equals(contractAbbr, contract.contractAbbr) &&
                Objects.equals(contractName, contract.contractName) &&
                Objects.equals(contractType, contract.contractType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contractId, contractAbbr, contractName, entityId, contractType, statusId);
    }
}
