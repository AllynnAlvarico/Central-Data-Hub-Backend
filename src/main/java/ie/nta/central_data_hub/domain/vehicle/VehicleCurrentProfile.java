package ie.nta.central_data_hub.domain.vehicle;

/**
 * VehicleCurrentProfile domain model tracking current vehicle deployment state.
 */
public class VehicleCurrentProfile{

    /**
     * Identifier of the vehicle.
     */
    private int vehicleId;

    /**
     * Identifier of the contract the vehicle is currently operating under.
     */
    private int contractId;

    /**
     * Identifier of the entity (operator) currently using the vehicle.
     */
    private int operatorId;

    /**
     * Identifier of the depot where the vehicle is currently based.
     */
    private int depotId;

    /**
     * Current status of the vehicle (maps to StatusVehicle enum).
     */
    private int vehicleStatusId;

    /**
     * Timestamp of the last profile update.
     */
    private String updatedAt;

    /**
     * Additional notes regarding the current assignment.
     */
    private String notes;

    /**
     * Parameterized constructor for manual vehicle profile creation.
     */
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
