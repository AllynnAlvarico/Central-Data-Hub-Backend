# AGENTS.md - Central Data Hub

## Project Overview
**Central Data Hub** is a Spring Boot 4.0.3 application (Java 21) serving as the authoritative data aggregation layer for the National Transport Authority (NTA). It consolidates multi-source raw data points into a single MongoDB instance for cleaning, processing, and analytical reporting.

**Key Purpose**: Acts as the primary data source for downstream analytics and reporting applications—similar to a SWDR but with emphasis on raw data consolidation and overview.

---

## Architecture & Data Model

### Hierarchical Domain Structure
The domain layer is organized by bounded context using a multi-level package hierarchy:

```
domain/
├── Entity.java                    # Root organizational unit
├── Contract.java                  # Service contracts
├── Depot.java                     # Physical locations
├── device/                        # Device management context
│   ├── Device.java               # Hardware/IoT device with status tracking
│   ├── DeviceModel.java          # Device specification templates
│   ├── DeviceType.java           # Device type taxonomy (GPS, Camera, etc.)
│   └── VehicleCurrentDevice.java # Association: vehicle → current devices
├── vehicle/                       # Vehicle management context
│   ├── Vehicle.java              # Fleet vehicles with identifiers
│   ├── VehicleModel.java         # Vehicle specification templates (deck type, fuel, length)
│   └── VehicleCurrentProfile.java # Association: vehicle → current assignment/status
└── assignment/                    # Relational assignments
    ├── DepotEntity.java          # Association: depot → entities with roles & date ranges
    └── EntityRole.java           # Association: entity → role type
```

### Entity Relationships
**Primary Entities**:
- **Entity** (`domain/Entity.java`): Root organizational unit (operators, authorities, suppliers) with `entityId`, `entityName`, `country`, `statusId`
- **Contract** (`domain/Contract.java`): Service contracts with `contractId`, `entityId` (foreign key), `contractType`, `statusId`
- **Depot** (`domain/Depot.java`): Physical operational/storage locations with `depotId`, `depotOperatorId` (foreign key)

**Device Context**:
- **Device** (`domain/device/Device.java`): Hardware units with `deviceId`, `deviceModelId`, `serialNumber`, dual status IDs (`currentStatusId` for operational health, `conditionStatusId` for deployment state)
- **DeviceModel** (`domain/device/DeviceModel.java`): Device specs linking `deviceTypeId` → device type, `entityId` → manufacturer
- **DeviceType** (`domain/device/DeviceType.java`): Taxonomy of device categories (e.g., GPS, on-board computer, camera)
- **VehicleCurrentDevice** (`domain/device/VehicleCurrentDevice.java`): Association tracking which devices are currently mounted on vehicles with `deviceRole` (e.g., "GPS_PRIMARY") and `mountLocation`

**Vehicle Context**:
- **Vehicle** (`domain/vehicle/Vehicle.java`): Fleet vehicles with `vehicleId`, `vehicleModelId`, `fleetId`, `contractId`, `registrationNumber`, `yearEnteredService`
- **VehicleModel** (`domain/vehicle/VehicleModel.java`): Vehicle specs with physical attributes (`deckType`, `length`, `fuelType`)
- **VehicleCurrentProfile** (`domain/vehicle/VehicleCurrentProfile.java`): Association tracking current vehicle deployment state (`contractId`, `operatorId`, `depotId`, `vehicleStatusId`)

**Assignment Context**:
- **DepotEntity** (`domain/assignment/DepotEntity.java`): Temporal assignment of entities to depots with `startDate`/`endDate` and `entityRoleId`
- **EntityRole** (`domain/assignment/EntityRole.java`): Role assignment of entities (who is the operator, supplier, etc.)

### Status Management Pattern
Comprehensive enum-based status tracking across multiple dimensions:

**Entity Lifecycle**:
- `StatusEntity`: ACTIVE (1), INACTIVE (2), SUSPENDED (3) — general entity operational state

**Vehicle States**:
- `StatusVehicle`: IN_SERVICE (1), OUT_OF_SERVICE (2), MAINTENANCE (3), RESERVE (4), RETIRED (5), UNKNOWN (6)

**Device Physical State**:
- `StatusDeviceCurrent`: NEW (1), GOOD (2), DEGRADED (3), FAULTY (4), FAILED (5), RETIRED (6)

**Device Deployment/Installation State**:
- `StatusConditionDevice`: ACTIVE (1), INACTIVE (2), ONLINE (3), OFFLINE (4), CONNECTED (5), MAINTENANCE (6), SPARE (7)

**Contract Lifecycle**:
- `StatusContract`: APPROVE (1), PENDING (2), ONHOLD (3), TERMINATED (4), CANCELLED (5), PENDING_REVIEW (6), UNDER_REVIEW (7)

**Entity Classification**:
- `RoleEntity`: AUTHORITY (1), OPERATOR (2), SUPPLIER (3), MANUFACTURER (4)

**⚠️ Critical Pattern**: Domain objects store raw integer status IDs (e.g., `int vehicleStatusId`). Enums provide semantic meaning via `getStatusId()`, `getStatusCode()`, and `getDescription()`. Helper methods to translate ID↔Enum are not yet implemented—add them when creating repository/service layers.

---

## Technology Stack & Configuration

### Dependencies
- **Spring Boot 4.0.3** with parent POM inheritance
- **MongoDB Data Spring**: `spring-boot-starter-data-mongodb` for async/reactive MongoDB operations
- **Lombok**: Annotation processor for reducing boilerplate (available but not yet widely used in domain classes)
- **Test Framework**: `spring-boot-starter-test` (JUnit 5 by default in Spring Boot 4)

### MongoDB Setup
- **Spring Boot 4.0 Property Rename**: `spring.data.mongodb.*` is removed in Spring Boot 4.0 — always use `spring.mongodb.*` prefix for all MongoDB properties
- **Configuration**: `config/MongoConfig.java` extends `AbstractMongoClientConfiguration`
- **Connection**: MongoDB Atlas via connection string in `application.properties`
- **Database**: Reads from `spring.mongodb.database` property via `@Value` in `MongoConfig.getDatabaseName()`
- **Target Database**: `Central_Data_Hub_Concept` (19 collections, ~423KB, Azure Europe North)
- **Startup Verification**: `CentralDataHubApplication.java` includes CommandLineRunner bean that pings MongoDB at startup, logs available databases and collections for troubleshooting

**⚠️ Resolved (2026-03-18)**: `MongoConfig.getDatabaseName()` now reads from `spring.mongodb.database` property. URI and database name are already separated. 

---

## Build & Deployment

### Maven Workflow
```bash
# Build with Maven wrapper
./mvnw clean package

# Run application
./mvnw spring-boot:run

# Run tests
./mvnw test
```

**Note**: Project uses Maven Wrapper (`mvnw`, `mvnw.cmd`) for consistent build environment across developers.

### Java Requirements
- **Java 21** (configured in pom.xml properties)
- Spring Boot 4.0.3 requires Java 17+

---

## Code Patterns & Conventions

### JavaDoc Documentation
The project enforces comprehensive JavaDoc documentation for all classes, fields, and methods to ensure maintainability and clarity for both developers and AI agents.
- **Classes**: Should include a brief description of their purpose and MongoDB collection mapping (if applicable).
- **Fields**: Should describe the data they hold and their mapping to database fields.
- **Methods**: Should explain their functionality, parameters, and return values.

### Entity Design Pattern
Domain classes follow a **stateless getter/setter pattern** with MongoDB mapping annotations:
- **No-argument constructor** for MongoDB deserialization (required for Spring Data)
- **Parameterized constructor** with all fields for convenient object creation
- **Individual setter/getter methods** for each private field (no validation logic)
- **MongoDB Annotations**: Use `@Document`, `@Id`, and `@Field` to map domain objects to MongoDB collections and fields.
- **No @Data, @Getter, @Setter annotations** applied yet — significant boilerplate reduction opportunity

**Canonical Example** (from `Entity.java`):
```java
@Document(collection = "collection_entity")
public class Entity {
    @Id
    private String id;
    
    @Field("entity_id")
    private long entityId;
    
    // ... fields
    
    public Entity() {}  // Required for serialization

    public Entity(long entityId, ...) {
        this.entityId = entityId;
        // ...
    }

    public long getEntityId() { return entityId; }
    public void setEntityId(long entityId) { this.entityId = entityId; }
    // ... repeat for each field
}
```

**MongoDB Considerations**: 
- Field names in POJO match MongoDB collection field names via `@Field` annotations.
- MongoDB uses the no-arg constructor for deserialization via Spring Data MongoDB
- Use `MongoRepository` for standard CRUD and custom query methods.

**Recommendation for AI agents**: When adding new domain classes, follow this exact pattern for consistency. Do NOT add Lombok annotations yet—this is a deliberate convention to maintain readability during this phase. Lombok migration is a future refactoring task.

### Package Structure
```
ie.nta.central_data_hub
├── domain/                                        # Domain entities with MongoDB mapping
│   ├── Entity.java, Contract.java, Depot.java
│   ├── device/                                    # Device context
│   └── vehicle/                                   # Vehicle context
├── repository/                                    # Spring Data MongoDB repositories
│   ├── EntityRepository.java
│   ├── VehicleRepository.java
│   ├── VehicleModelRepository.java
│   ├── ContractRepository.java
│   └── EntityRoleRepository.java
├── service/                                       # Service layer for business logic
│   ├── EntityService.java
│   ├── VehicleService.java
│   ├── VehicleModelService.java
│   └── ContractService.java
├── controller/                                    # REST Controllers
│   ├── EntityController.java
│   ├── VehicleController.java
│   ├── VehicleModelController.java
│   └── ContractController.java
├── enums/                                         # Status and role enumerations
├── config/
│   └── MongoConfig.java                          # MongoDB client & database setup
└── CentralDataHubApplication.java                # Spring Boot entry point & diagnostics bean
```

---

## Integration Points & Data Flow

### MongoDB Collections
The application dynamically discovers and logs all collections in all databases (except system DBs) during startup. This aids debugging and understanding the data schema without separate documentation.

**Current Database**: `Central_Data_Hub_Concept` (configured in `application.properties`)

### Startup Diagnostics
The CommandLineRunner bean in `CentralDataHubApplication` performs:
1. MongoDB connectivity ping
2. Lists all collections in the current database
3. Lists all non-system databases and their collections
4. Logs any connection errors for troubleshooting

**Usage**: Monitor application logs to understand data schema and identify missing or misconfigured collections.

---

## Developer Workflow Notes

### Local Development
1. Verify MongoDB Atlas connectivity and credentials in `application.properties`
2. Ensure Java 21 is installed (`java -version`)
3. Use `./mvnw` for all Maven operations to guarantee consistency
4. Check startup logs for MongoDB collection discovery and connection status

### Common Tasks
- **Adding new domain entities**: Create class in `domain/`, add corresponding status enum in `enums/` if needed, follow getter/setter pattern with `@Document` mapping.
- **Creating Repositories**: Extend `MongoRepository<T, String>` and add custom query methods following naming conventions.
- **Implementing Services**: Inject repositories and provide methods for retrieval, search, and business logic.
- **Exposing Endpoints**: Create controllers with `@RestController` and `@RequestMapping`.

### Configuration Management
- Single properties file: `application.properties`
- No Spring profiles configured (dev/test/prod separation not yet implemented)
- **Spring Boot 4.0 Note**: Use `spring.mongodb.uri` and `spring.mongodb.database` (NOT `spring.data.mongodb.*` — those are removed in 4.0)
- URI path must NOT contain the database name (e.g. end with `/` not `/TestDatabase`) — use `spring.mongodb.database` property instead, otherwise it overrides `MongoConfig.getDatabaseName()`
- **Resolved (2026-03-18)**: `MongoConfig.getDatabaseName()` now reads from `spring.mongodb.database` property. URI and database name are already separated. Next step: implement Spring profiles for dev/staging/prod.

---

## Known Gaps & Future Considerations

1. **Repository Layer Incomplete**: Some domain classes (Depot, Device, etc.) lack repository interfaces.
2. **REST Controllers Incomplete**: Some domain contexts lack controllers.
3. **Minimal Error Handling**: Domain classes and services have no validation or exception handling.
4. **No Logging Strategy**: Domain layer has no structured logging pattern (only application startup logging).
5. **Test Coverage**: Only application context test and some specific data retrieval tests exist; more coverage needed.
6. **Lombok Underutilized**: Imported but not used; significant boilerplate reduction opportunity.

---

## Key Files Reference

| File | Purpose |
|------|---------|
| `pom.xml` | Maven dependencies and build config |
| `config/MongoConfig.java` | MongoDB client setup and database configuration |
| `CentralDataHubApplication.java` | Spring Boot entry point, startup diagnostics |
| `domain/*.java` | Entity/model classes (Vehicle, Device, Entity, etc.) |
| `repository/*.java` | Data access layer using Spring Data MongoDB |
| `service/*.java` | Business logic and repository coordination |
| `controller/*.java` | REST API endpoints |
| `enums/*.java` | Status and role enumerations with semantic mappings |
| `application.properties` | MongoDB connection string and app metadata |

---

## Communication for AI Agents

When modifying this codebase:
1. **Preserve domain model structure**: Domain classes use a specific pattern; maintain consistency.
2. **Consider MongoDB mapping**: Use `@Document`, `@Id`, and `@Field` annotations for new domain classes.
3. **Follow the Repository-Service-Controller pattern**: Ensure new features are layered correctly.
4. **Test MongoDB connectivity**: After configuration changes, verify startup diagnostics log successful connection.
5. **Document status code meanings**: When adding new status enums, include javadoc comments explaining numeric IDs and their lifecycle purpose.
6. **Avoid hardcoded values**: Use `application.properties` for configuration.