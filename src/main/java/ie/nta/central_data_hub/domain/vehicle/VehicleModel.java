package ie.nta.central_data_hub.domain.vehicle;

public class VehicleModel {

    private String vehicleModelId;
    private int entityId;
    private String vehicleModelName;
    private String deckType;
    private double length;
    private String fuelType;

    public VehicleModel(String vehicleModelId, int entityId, String vehicleModelName, String deckType, double length, String fuelType) {
        this.vehicleModelId = vehicleModelId;
        this.entityId = entityId;
        this.vehicleModelName = vehicleModelName;
        this.deckType = deckType;
        this.length = length;
        this.fuelType = fuelType;
    }

    public void setVehicleModelId(String vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    public void setDeckType(String deckType) {
        this.deckType = deckType;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getVehicleModelId() {
        return vehicleModelId;
    }

    public int getEntityId() {
        return entityId;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public String getDeckType() {
        return deckType;
    }

    public double getLength() {
        return length;
    }

    public String getFuelType() {
        return fuelType;
    }
}
