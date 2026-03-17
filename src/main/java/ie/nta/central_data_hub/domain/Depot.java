package ie.nta.central_data_hub.domain;

public class Depot {

    private int depotId;
    private String depotCode;
    private String depotName;
    private int depotOperatorId;
    private String locationName;

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
