package ie.nta.central_data_hub.domain.assignment;

public class DepotEntity {

    private int depotEntityId;
    private int depotId;
    private int entityId;
    private int entityRoleId;
    private String startDate;
    private String endDate;

    public DepotEntity() {}

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
