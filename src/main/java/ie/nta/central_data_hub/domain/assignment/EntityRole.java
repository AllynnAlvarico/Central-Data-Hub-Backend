package ie.nta.central_data_hub.domain.assignment;

public class EntityRole {
    private int entityRoleAssignmentId;
    private int entityId;
    private int entityRoleId;

    public EntityRole(int entityRoleAssignmentId, int entityId, int entityRoleId) {
        this.entityRoleAssignmentId = entityRoleAssignmentId;
        this.entityId = entityId;
        this.entityRoleId = entityRoleId;
    }

    public void setEntityRoleAssignmentId(int entityRoleAssignmentId) {
        this.entityRoleAssignmentId = entityRoleAssignmentId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public void setEntityRoleId(int entityRoleId) {
        this.entityRoleId = entityRoleId;
    }

    public int getEntityRoleAssignmentId() {
        return entityRoleAssignmentId;
    }

    public int getEntityId() {
        return entityId;
    }

    public int getEntityRoleId() {
        return entityRoleId;
    }
}
