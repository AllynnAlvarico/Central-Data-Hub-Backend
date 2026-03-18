package ie.nta.central_data_hub.domain.assignment;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * EntityRole association model mapping an entity to its role in the system.
 * Examples: operators, manufacturers, suppliers.
 */
@Document(collection = "assignment_entity_role")
public class EntityRole {
    @Id
    private String id;

    @Field("entity_role_assignment_id")
    private int entityRoleAssignmentId;

    @Field("entity_id")
    private long entityId;

    @Field("entity_role_id")
    private int entityRoleId;

    public EntityRole() {}

    public EntityRole(int entityRoleAssignmentId, long entityId, int entityRoleId) {
        this.entityRoleAssignmentId = entityRoleAssignmentId;
        this.entityId = entityId;
        this.entityRoleId = entityRoleId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEntityRoleAssignmentId(int entityRoleAssignmentId) {
        this.entityRoleAssignmentId = entityRoleAssignmentId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    public void setEntityRoleId(int entityRoleId) {
        this.entityRoleId = entityRoleId;
    }

    public int getEntityRoleAssignmentId() {
        return entityRoleAssignmentId;
    }

    public long getEntityId() {
        return entityId;
    }

    public int getEntityRoleId() {
        return entityRoleId;
    }

    @Override
    public String toString() {
        return "EntityRole{" +
                "id='" + id + '\'' +
                ", entityRoleAssignmentId=" + entityRoleAssignmentId +
                ", entityId=" + entityId +
                ", entityRoleId=" + entityRoleId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityRole that = (EntityRole) o;

        if (entityRoleAssignmentId != that.entityRoleAssignmentId) return false;
        if (entityId != that.entityId) return false;
        if (entityRoleId != that.entityRoleId) return false;
        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + entityRoleAssignmentId;
        result = 31 * result + (int) (entityId ^ (entityId >>> 32));
        result = 31 * result + entityRoleId;
        return result;
    }
}
