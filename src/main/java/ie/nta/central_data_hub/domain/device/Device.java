package ie.nta.central_data_hub.domain.device;

/**
 * Device domain model representing hardware or IoT devices installed on vehicles.
 */
public class Device {

    /**
     * Unique identifier for the device.
     */
    private int deviceId;

    /**
     * Identifier for the device model specifications.
     */
    private int deviceModelId;

    /**
     * Manufacturer-provided serial number.
     */
    private String serialNumber;

    /**
     * Operational health status (maps to StatusDeviceCurrent enum).
     */
    private int currentStatusId;

    /**
     * Deployment/installation state (maps to StatusConditionDevice enum).
     */
    private int conditionStatusId;

    /**
     * Timestamp of the last device status update.
     */
    private String lastUpdate;

    /**
     * Additional notes regarding the device's condition or deployment.
     */
    private String notes;

    /**
     * Parameterized constructor for manual device creation.
     */
    public Device(int deviceId, int deviceModelId, String serialNumber, int currentStatusId, String lastUpdate, String notes) {
        this.deviceId = deviceId;
        this.deviceModelId = deviceModelId;
        this.serialNumber = serialNumber;
        this.currentStatusId = currentStatusId;
        this.lastUpdate = lastUpdate;
        this.notes = notes;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public void setDeviceModelId(int deviceModelId) {
        this.deviceModelId = deviceModelId;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setCurrentStatusId(int currentStatusId) {
        this.currentStatusId = currentStatusId;
    }

    public void setConditionStatusId(int conditionStatusId) {
        this.conditionStatusId = conditionStatusId;
    }
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public int getDeviceModelId() {
        return deviceModelId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getCurrentStatusId() {
        return currentStatusId;
    }

    public int getConditionStatusId() {
        return conditionStatusId;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public String getNotes() {
        return notes;
    }
}
