
/**
 * Represents the lifecycle status of a contract in the system.
 * Tracks whether a contract is approved, pending decision, on hold, terminated,
 * cancelled, awaiting review, or currently under review.
 */
package ie.nta.central_data_hub.enums;

public enum StatusContract {

    APPROVE(1, "APPROVE", "Contract approved and active"),
    PENDING(2, "PENDING", "Contract pending decision"),
    ONHOLD(3, "ONHOLD", "Contract on hold"),
    TERMINATED(4, "TERMINATED", "Contract ended before normal completion"),
    CANCELLED(5, "CANCELLED", "Contract cancelled and not in force"),
    PENDING_REVIEW(6, "PENDING_REVIEW", "Contract awaiting review"),
    UNDER_REVIEW(7, "UNDER_REVIEW", "Contract currently under review");

    private final int statusId;
    private final String statusCode;
    private final String description;

    StatusContract(int statusId, String statusCode, String description) {
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
