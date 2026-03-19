package ie.nta.central_data_hub.domain.assignment;

/**
 * DepotEntity association model mapping a depot to its assigned entity.
 * Represents a temporal assignment of an entity to a specific depot.
 */
public class DepotEntity {

    /**
     * Unique identifier for the depot-entity assignment.
     */
    private int depotEntityId;

    /**
     * Identifier of the depot.
     */
    private int depotId;

    /**
     * Identifier of the entity assigned to the depot.
     */
    private int entityId;

    /**
     * Identifier of the role the entity performs at the depot.
     */
    private int entityRoleId;

    /**
     * The date when the assignment begins (ISO format).
     */
    private String startDate;

    /**
     * The date when the assignment ends (ISO format).
     */
    private String endDate;

    /**
     * Default constructor.
     */
    public DepotEntity() {}

    /**
     * Parameterized constructor for manual depot-entity assignment creation.
     */
    public DepotEntity(int depotEntityId, int depotId, int entityId,int entityRoleId, String startDate, String endDate) {
        this.depotEntityId = depotEntityId;
        this.depotId = depotId;
        this.entityId = entityId;
        this.entityRoleId = entityRoleId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setDepotEntityId(int depotEntityId) {
        this.depotEntityId = depotEntityId;
    }

    public void setDepotId(int depotId) {
        this.depotId = depotId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public void setEntityRoleId(int entityRoleId) {
        this.entityRoleId = entityRoleId;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getDepotEntityId() {
        return depotEntityId;
    }

    public int getDepotId() {
        return depotId;
    }

    public int getEntityId() {
        return entityId;
    }

    public int getEntityRoleId() {
        return entityRoleId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
