package ie.nta.central_data_hub.domain.vehicle;

public class VehicleCurrentProfile{

    private int vehicleId;
    private int contractId;
    private int operatorId;
    private int depotId;
    private int vehicleStatusId;
    private String updatedAt;
    private String notes;

    public VehicleCurrentProfile(int vehicleId, int contractId, int operatorId, int depotId, int vehicleStatusId, String updatedAt, String notes) {
        this.vehicleId = vehicleId;
        this.contractId = contractId;
        this.operatorId = operatorId;
        this.depotId = depotId;
        this.vehicleStatusId = vehicleStatusId;
        this.updatedAt = updatedAt;
        this.notes = notes;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public void setDepotId(int depotId) {
        this.depotId = depotId;
    }

    public void setVehicleStatusId(int vehicleStatusId) {
        this.vehicleStatusId = vehicleStatusId;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public int getContractId() {
        return contractId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public int getDepotId() {
        return depotId;
    }

    public int getVehicleStatusId() {
        return vehicleStatusId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getNotes() {
        return notes;
    }
}
