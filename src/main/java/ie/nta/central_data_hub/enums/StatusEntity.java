/**
 * Represents the general lifecycle status of a system entity.
 * Indicates whether an entity is actively in use, inactive (deactivated),
 * or pending activation or processing.
 */
package ie.nta.central_data_hub.enums;

public enum StatusEntity {

    ACTIVE(1, "ACTIVE", "Active status"),
    INACTIVE(2, "INACTIVE", "Inactive status"),
    PENDING(3, "SUSPENDED", "Entity is temporarily suspended");

    private final int statusId;
    private final String statusCode;
    private final String description;

    StatusEntity(int statusId, String statusCode, String description) {
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