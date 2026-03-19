package ie.nta.central_data_hub.domain.vehicle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "collection_vehicle")
public class Vehicle {

    @Id
    private String id;
    
    @Field("vehicle_id")
    private long vehicleId;
    
    @Field("vehicle_model_id")
    private long vehicleModelId;
    
    @Field("fleet_number")
    private String fleetNumber;
    
    @Field("operator")
    private long operator;
    
    @Field("year_entered_service")
    private int yearEnteredService;
    
    @Field("contract_id")
    private long contractId;
    
    @Field("registration")
    private String registration;

    public Vehicle() {
    }

    public Vehicle(long vehicleId, long vehicleModelId, String fleetNumber, long operator, int yearEnteredService, long contractId, String registration) {
        this.vehicleId = vehicleId;
        this.vehicleModelId = vehicleModelId;
        this.fleetNumber = fleetNumber;
        this.operator = operator;
        this.yearEnteredService = yearEnteredService;
        this.contractId = contractId;
        this.registration = registration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setVehicleModelId(long vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }

    public void setFleetNumber(String fleetNumber) {
        this.fleetNumber = fleetNumber;
    }

    public void setOperator(long operator) {
        this.operator = operator;
    }

    public void setYearEnteredService(int yearEnteredService) {
        this.yearEnteredService = yearEnteredService;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public long getVehicleModelId() {
        return vehicleModelId;
    }

    public String getFleetNumber() {
        return fleetNumber;
    }

    public long getOperator() {
        return operator;
    }

    public int getYearEnteredService() {
        return yearEnteredService;
    }

    public long getContractId() {
        return contractId;
    }

    public String getRegistration() {
        return registration;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", vehicleId=" + vehicleId +
                ", vehicleModelId=" + vehicleModelId +
                ", fleetNumber='" + fleetNumber + '\'' +
                ", operator=" + operator +
                ", yearEnteredService=" + yearEnteredService +
                ", contractId=" + contractId +
                ", registration='" + registration + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (vehicleId != vehicle.vehicleId) return false;
        if (vehicleModelId != vehicle.vehicleModelId) return false;
        if (operator != vehicle.operator) return false;
        if (yearEnteredService != vehicle.yearEnteredService) return false;
        if (contractId != vehicle.contractId) return false;
        if (id != null ? !id.equals(vehicle.id) : vehicle.id != null) return false;
        if (fleetNumber != null ? !fleetNumber.equals(vehicle.fleetNumber) : vehicle.fleetNumber != null) return false;
        return registration != null ? registration.equals(vehicle.registration) : vehicle.registration == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (int) (vehicleId ^ (vehicleId >>> 32));
        result = 31 * result + (int) (vehicleModelId ^ (vehicleModelId >>> 32));
        result = 31 * result + (fleetNumber != null ? fleetNumber.hashCode() : 0);
        result = 31 * result + (int) (operator ^ (operator >>> 32));
        result = 31 * result + yearEnteredService;
        result = 31 * result + (int) (contractId ^ (contractId >>> 32));
        result = 31 * result + (registration != null ? registration.hashCode() : 0);
        return result;
    }
}
