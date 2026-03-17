/**
 * Represents the operational and installation condition of a device in the system.
 * Indicates whether a device is actively in use, inactive, online, offline,
 * connected, under maintenance, or held as a spare unit.
 */
package ie.nta.central_data_hub.enums;

public enum StatusConditionDevice {

    ACTIVE(1, "ACTIVE", "Device is installed and actively in use"),
    INACTIVE(2, "INACTIVE", "Device is not currently in use"),
    ONLINE(3, "ONLINE", "Device is online"),
    OFFLINE(4, "OFFLINE", "Device is offline"),
    CONNECTED(5, "CONNECTED", "Device is connected"),
    MAINTENANCE(6, "MAINTENANCE", "Device is out of service for maintenance or testing"),
    SPARE(7, "SPARE", "Device is spare");

    private final int statusId;
    private final String statusName;
    private final String statusDescription;

    private StatusConditionDevice(int statusId, String statusName, String statusDescription) {
        this.statusId = statusId;
        this.statusName = statusName;
        this.statusDescription = statusDescription;
    }

    public int getStatusId() {
        return statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public String getStatusDescription() {
        return statusDescription;
    }
}
