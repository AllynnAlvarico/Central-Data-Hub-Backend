package ie.nta.central_data_hub.domain.vehicle;

public class Vehicle {

    private int vehicleId;
    private int vehicleModelId;
    private String fleetId;
    private int operator;
    private int yearEnteredService;
    private int contractId;
    private String registrationNumber;

    public Vehicle(int vehicleId, int vehicleModelId, String fleetId, int operator, int yearEnteredService, int contractId, String registrationNumber) {
        this.vehicleId = vehicleId;
        this.vehicleModelId = vehicleModelId;
        this.fleetId = fleetId;
        this.operator = operator;
        this.yearEnteredService = yearEnteredService;
        this.contractId = contractId;
        this.registrationNumber = registrationNumber;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setVehicleModelId(int vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }

    public void setFleetId(String fleetId) {
        this.fleetId = fleetId;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public void setYearEnteredService(int yearEnteredService) {
        this.yearEnteredService = yearEnteredService;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public int getVehicleModelId() {
        return vehicleModelId;
    }

    public String getFleetId() {
        return fleetId;
    }

    public int getOperator() {
        return operator;
    }

    public int getYearEnteredService() {
        return yearEnteredService;
    }

    public int getContractId() {
        return contractId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

}
