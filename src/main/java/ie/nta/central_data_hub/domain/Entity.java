package ie.nta.central_data_hub.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Entity domain model representing organizational units in the system.
 * Maps to the "collection_entity" MongoDB collection.
 * Examples: operators, authorities, suppliers, manufacturers.
 */
@Document(collection = "collection_entity")
public class Entity {

    /**
     * MongoDB document identifier (auto-generated ObjectId if null on save).
     */
    @Id
    private String id;
    
    /**
     * Business identifier for the entity (unique within domain).
     */
    @Field("entity_id")
    private long entityId;

    /**
     * Entity code (abbreviation or code identifier).
     */
    @Field("entity_code")
    private String entityCode;

    /**
     * Full name of the entity.
     */
    @Field("entity_name")
    private String entityName;

    /**
     * Country where entity operates.
     */
    @Field("country")
    private String country;

    /**
     * Status identifier mapping to StatusEntity enum (1=ACTIVE, 2=INACTIVE, 3=SUSPENDED).
     */
    @Field("status_id")
    private int statusId;
    
    public Entity() {
    }
    
    public Entity(long entityId, String entityCode, String entityName, String country, int statusId) {
        this.entityId = entityId;
        this.entityCode = entityCode;
        this.entityName = entityName;
        this.country = country;
        this.statusId = statusId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getEntityId() {
        return entityId;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getCountry() {
        return country;
    }

    public int getStatusId() {
        return statusId;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + '\'' +
                ", entityId=" + entityId +
                ", entityCode='" + entityCode + '\'' +
                ", entityName='" + entityName + '\'' +
                ", country='" + country + '\'' +
                ", statusId=" + statusId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        if (entityId != entity.entityId) return false;
        if (statusId != entity.statusId) return false;
        if (id != null ? !id.equals(entity.id) : entity.id != null) return false;
        if (entityCode != null ? !entityCode.equals(entity.entityCode) : entity.entityCode != null) return false;
        if (entityName != null ? !entityName.equals(entity.entityName) : entity.entityName != null) return false;
        return country != null ? country.equals(entity.country) : entity.country == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (int) (entityId ^ (entityId >>> 32));
        result = 31 * result + (entityCode != null ? entityCode.hashCode() : 0);
        result = 31 * result + (entityName != null ? entityName.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + statusId;
        return result;
    }
}
