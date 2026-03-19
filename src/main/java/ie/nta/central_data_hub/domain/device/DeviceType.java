package ie.nta.central_data_hub.domain.device;

/**
 * DeviceType domain model defining taxonomy categories for devices.
 * Examples: GPS, Camera, On-Board Computer.
 */
public class DeviceType {

    /**
     * Unique identifier for the device type.
     */
    private int deviceTypeId;

    /**
     * Short code identifying the device type.
     */
    private String deviceCode;

    /**
     * Full name of the device type.
     */
    private String deviceName;

    /**
     * Parameterized constructor for manual device type creation.
     */
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
