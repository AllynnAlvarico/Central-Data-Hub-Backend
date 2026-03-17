package ie.nta.central_data_hub.enums;

/**
 * Represents the current physical condition and health state of a device.
 * Indicates whether a device is new and unused, in good working condition,
 * degraded in performance, faulty, completely failed, or permanently retired from use.
 */
public enum StatusDeviceCurrent {
    NEW(1, "NEW", "Device is new and unused"),
    GOOD(2, "GOOD", "Device is good working condition"),
    DEGRADED(3, "DEGRADED", "Device works but shows issues or reduced performance"),
    FAUTY(4, "FAULTY", "Device is faulty and may not operate correctly"),
    FAILED(5, "FAILED", "Device is not functioning and cannot be used"),
    RETIRED(6, "RETIRED", "Device is retired and permanently removed from use");

    private final int statusId;
    private final String statusName;
    private final String statusDescription;

    private StatusDeviceCurrent(int statusId, String statusName, String statusDescription) {
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
