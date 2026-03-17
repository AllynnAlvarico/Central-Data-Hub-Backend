package ie.nta.central_data_hub.domain.device;

public class Device {

    private int deviceId;
    private int deviceModelId;
    private String serialNumber;
    private int currentStatusId;
    private int conditionStatusId;
    private String lastUpdate;
    private String notes;

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
