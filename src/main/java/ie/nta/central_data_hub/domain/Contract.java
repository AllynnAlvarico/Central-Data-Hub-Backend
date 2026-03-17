package ie.nta.central_data_hub.domain;

public class Contract {

    private int contractId;
    private String contractAbbr;
    private String contractName;
    private int entityId;
    private String contractType;
    private int statusId;

    public Contract(int contractId, String contractAbbr, String contractName, int entityId, String contractType, int statusId) {
        this.contractId = contractId;
        this.contractAbbr = contractAbbr;
        this.contractName = contractName;
        this.entityId = entityId;
        this.contractType = contractType;
        this.statusId = statusId;
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
}
