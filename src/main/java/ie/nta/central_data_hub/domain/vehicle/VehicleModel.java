package ie.nta.central_data_hub.domain.vehicle;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * VehicleModel domain model representing specifications of a vehicle model.
 * Maps to the "collection_vehicle_model" MongoDB collection.
 */
@Document(collection = "collection_vehicle_model")
public class VehicleModel {

    /**
     * MongoDB document identifier.
     */
    @Id
    private String id;

    /**
     * Unique business identifier for the vehicle model.
     */
    @Field("vehicle_model_id")
    private long vehicleModelId;

    /**
     * Identifier of the entity (manufacturer) that produces this model.
     */
    @Field("entity_id")
    private long entityId;

    /**
     * Name of the vehicle model.
     */
    @Field("model_name")
    private String vehicleModelName;

    /**
     * Type of deck (e.g., SINGLE, DOUBLE).
     */
    @Field("deck_type")
    private String deckType;

    /**
     * Length of the vehicle in meters.
     */
    @Field("length")
    private Double length;

    /**
     * Type of fuel used by the vehicle.
     */
    @Field("fuel_type")
    private String fuelType;

    /**
     * Default constructor required for MongoDB deserialization.
     */
    public VehicleModel() {}

    /**
     * Parameterized constructor for manual vehicle model creation.
     */
    public VehicleModel(long vehicleModelId, long entityId, String vehicleModelName, String deckType, Double length, String fuelType) {
        this.vehicleModelId = vehicleModelId;
        this.entityId = entityId;
        this.vehicleModelName = vehicleModelName;
        this.deckType = deckType;
        this.length = length;
        this.fuelType = fuelType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVehicleModelId(long vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    public void setDeckType(String deckType) {
        this.deckType = deckType;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public long getVehicleModelId() {
        return vehicleModelId;
    }

    public long getEntityId() {
        return entityId;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public String getDeckType() {
        return deckType;
    }

    public Double getLength() {
        return length;
    }

    public String getFuelType() {
        return fuelType;
    }
}
