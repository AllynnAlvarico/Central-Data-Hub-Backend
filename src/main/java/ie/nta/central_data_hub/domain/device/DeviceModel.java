package ie.nta.central_data_hub.domain.device;

/**
 * DeviceModel domain model representing specification templates for hardware devices.
 */
public class DeviceModel {

    /**
     * Unique identifier for the device model.
     */
    private int deviceModelId;

    /**
     * Identifier for the type of device (maps to DeviceType).
     */
    private int deviceTypeId;

    /**
     * Identifier of the entity (manufacturer) that produces this model.
     */
    private int entityId;

    /**
     * Name of the device model.
     */
    private String modelName;

    /**
     * Short code or version identifier for the model.
     */
    private String modelCode;

    /**
     * Parameterized constructor for manual device model creation.
     */
    public DeviceModel(int deviceModelId, int deviceTypeId, int entityId, String modelName, String modelCode) {
        this.deviceModelId = deviceModelId;
        this.deviceTypeId = deviceTypeId;
        this.entityId = entityId;
        this.modelName = modelName;
        this.modelCode = modelCode;
    }

    public void setDeviceModelId(int deviceModelId) {
        this.deviceModelId = deviceModelId;
    }

    public void setDeviceTypeId(int deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public int getDeviceModelId() {
        return deviceModelId;
    }

    public int getDeviceTypeId() {
        return deviceTypeId;
    }

    public int getEntityId() {
        return entityId;
    }

    public String getModelName() {
        return modelName;
    }

    public String getModelCode() {
        return modelCode;
    }
}
