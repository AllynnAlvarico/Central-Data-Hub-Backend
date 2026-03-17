package ie.nta.central_data_hub.domain.device;

public class VehicleCurrentDevice {
    private int deviceCurrentId;
    private int vehicleId;
    private int deviceId;
    private String deviceRole;
    private String mountLocation;
    private String updatedAt;
    private String notes;

    public VehicleCurrentDevice() {
    }

    public VehicleCurrentDevice(int deviceCurrentId, int vehicleId, int deviceId, String deviceRole, String mountLocation, String updatedAt, String notes) {
        this.deviceCurrentId = deviceCurrentId;
        this.vehicleId = vehicleId;
        this.deviceId = deviceId;
        this.deviceRole = deviceRole;
        this.mountLocation = mountLocation;
        this.updatedAt = updatedAt;
        this.notes = notes;
    }

    public void setDeviceCurrentId(int deviceCurrentId) {
        this.deviceCurrentId = deviceCurrentId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public void setDeviceRole(String deviceRole) {
        this.deviceRole = deviceRole;
    }

    public void setMountLocation(String mountLocation) {
        this.mountLocation = mountLocation;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getDeviceCurrentId() {
        return deviceCurrentId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public String getDeviceRole() {
        return deviceRole;
    }

    public String getMountLocation() {
        return mountLocation;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getNotes() {
        return notes;
    }
}
