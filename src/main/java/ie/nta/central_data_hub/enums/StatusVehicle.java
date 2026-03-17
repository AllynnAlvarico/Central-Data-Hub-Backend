/**
 * Represents the operational status of a vehicle in the system.
 * Indicates whether a vehicle is actively in service, temporarily out of service,
 * undergoing maintenance, held in reserve, permanently retired, or has an unknown status.
 */
package ie.nta.central_data_hub.enums;

public enum StatusVehicle {

    IN_SERVICE(1, "IN_SERVICE", "Vehicle is available and in normal service"),
    OUT_OF_SERVICE(2, "OUT_OF_SERVICE", "Vehicle is temporarily out of service"),
    MAINTENANCE(3, "MAINTENANCE", "Vehicle is in maintenance / repair"),
    RESERVE(4, "RESERVE", "Vehicle is in reserve / spare pool"),
    RETIRED(5, "RETIRED", "Vehicle permanently removed from service"),
    UNKNOWN(6, "UNKNOWN", "Unknown or Missing Data");

    private final int statusId;
    private final String statusCode;
    private final String description;

    StatusVehicle(int statusId, String statusCode, String description) {
        this.statusId = statusId;
        this.statusCode = statusCode;
        this.description = description;
    }

    public int getStatusId() {
        return statusId;
    }
    public String getStatusCode() {
        return statusCode;
    }

    public String getDescription() {
        return description;
    }
}
