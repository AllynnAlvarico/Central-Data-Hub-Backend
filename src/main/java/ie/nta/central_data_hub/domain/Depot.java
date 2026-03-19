package ie.nta.central_data_hub.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Depot domain model representing a physical operational or storage location.
 */
public class Depot {

    /**
     * Unique identifier for the depot.
     */
    @Id
    private int depotId;

    /**
     * Short code or abbreviation for the depot.
     */
    @Field("depot_code")
    private String depotCode;

    /**
     * Full name of the depot.
     */
    @Field("depot_name")
    private String depotName;

    /**
     * Identifier of the entity (operator) that manages this depot.
     */
    @Field("depot_operator")
    private int depotOperatorId;

    /**
     * Geographical or descriptive location name.
     */
    @Field("location")
    private String locationName;

    public Depot() {
    }

    /**
     * Parameterized constructor for manual depot creation.
     */
    public Depot(int depotId, String depotCode, String depotName, int depotOperatorId, String locationName) {
        this.depotId = depotId;
        this.depotCode = depotCode;
        this.depotName = depotName;
        this.depotOperatorId = depotOperatorId;
        this.locationName = locationName;
    }

    public void setDepotId(int depotId) {
        this.depotId = depotId;
    }

    public void setDepotCode(String depotCode) {
        this.depotCode = depotCode;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    public void setDepotOperatorId(int depotOperatorId) {
        this.depotOperatorId = depotOperatorId;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getDepotId() {
        return depotId;
    }

    public String getDepotCode() {
        return depotCode;
    }

    public String getDepotName() {
        return depotName;
    }

    public int getDepotOperatorId() {
        return depotOperatorId;
    }

    public String getLocationName() {
        return locationName;
    }
}
