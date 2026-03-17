package ie.nta.central_data_hub.domain.device;

public class DeviceType {

    private int deviceTypeId;
    private String deviceCode;
    private String deviceName;
    public DeviceType(int deviceTypeId, String deviceCode, String deviceName) {
        this.deviceTypeId = deviceTypeId;
        this.deviceCode = deviceCode;
        this.deviceName = deviceName;
    }

    public void setDeviceTypeId(int deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getDeviceTypeId() {
        return deviceTypeId;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public String getDeviceName() {
        return deviceName;
    }
}
