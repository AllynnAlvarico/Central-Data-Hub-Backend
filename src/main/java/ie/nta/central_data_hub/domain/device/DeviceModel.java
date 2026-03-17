package ie.nta.central_data_hub.domain.device;

public class DeviceModel {

    private int deviceModelId;
    private int deviceTypeId;
    private int entityId;
    private String modelName;
    private String modelCode;

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
