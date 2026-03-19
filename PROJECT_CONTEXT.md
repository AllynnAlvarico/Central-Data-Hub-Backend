# PROJECT CONTEXT: Central Data Hub (NTA)

## 1. Project Overview & Mission
**Central Data Hub** is a robust Spring Boot 4.0.3 application (Java 21) designed as the authoritative data aggregation layer for the **National Transport Authority (NTA)**. Its primary mission is to consolidate multi-source raw transport data (vehicles, devices, contracts, entities) into a single MongoDB instance. It serves as a "Single Version of Truth" for cleaning, processing, and providing clean data for downstream analytics and reporting.

### Developer Goals:
- Maintain a clean, modular Spring Boot architecture.
- Ensure strict adherence to the Repository-Service-Controller pattern.
- Implement comprehensive JavaDoc for maintainability and AI collaboration.
- Minimize boilerplate code while preserving readability.
- Scale the data model to support complex transportation contexts (IoT devices, fleet management, temporal assignments).

### User/Stakeholder Goals:
- Access consolidated, reliable raw data for NTA operations.
- Enable high-performance reporting through a structured API layer.
- Ensure data integrity across multiple transport entities and contracts.

---

## 2. Technical Stack
- **Framework**: Spring Boot 4.0.3
- **Language**: Java 21
- **Database**: MongoDB (Spring Data MongoDB)
- **Build Tool**: Maven (with Wrapper)
- **Persistence**: MongoDB Atlas (Azure Europe North)

---

## 3. Core Architectural Summary
The project follows a standard N-tier architecture:
1. **Controller Layer**: REST API endpoints for data retrieval and operations.
2. **Service Layer**: Business logic, data transformation, and repository coordination.
3. **Repository Layer**: Spring Data MongoDB interfaces for database access.
4. **Domain Layer**: POJOs mapped to MongoDB collections via `@Document` and `@Field`.
5. **Enums**: Semantic status and role management using integer-based mappings.

---

## 4. Class & Method Reference

### Domain Entities (`ie.nta.central_data_hub.domain`)
- **Entity**: Represents organizational units (Operators, Authorities, Suppliers).
    - *Fields*: `entityId`, `entityName`, `country`, `statusId`.
- **Contract**: Manages service agreements.
    - *Fields*: `contractId`, `entityId`, `contractType`, `statusId`.
- **Depot**: Physical locations for fleet storage/operations.
- **Vehicle (in `vehicle/`)**: Fleet vehicle information.
    - *Fields*: `vehicleId`, `vehicleModelId`, `fleetId`, `registrationNumber`, etc.
- **Device (in `device/`)**: IoT/Hardware units (GPS, Cameras).

### Services (`ie.nta.central_data_hub.service`)
- **EntityService**: 
    - `getAllEntities()`: Retrieves all entities.
    - `searchByNameStartingWith(String prefix)`: Search entities by name prefix.
    - `getEntitiesByRole(RoleEntity role)`: Filters entities based on their assigned role (e.g., OPERATOR).
- **VehicleService**:
    - `getVehicleByFleetNumber(String fleetNumber)`: Find vehicle by fleet ID.
    - `getVehicleByBusinessId(long vehicleId)`: Find vehicle by its unique business ID.
    - `getVehiclesByOperator(long operatorId)`: List all vehicles belonging to an operator.
    - `getVehicleTotalCount()`: Return total count of vehicles.
- **ContractService**:
    - `getContractByBusinessId(int contractId)`: Find contract by ID.
    - `getContractsByStatus(int statusId)`: Filter contracts by lifecycle state.
    - `getContractsByEntity(int entityId)`: Find all contracts for a specific entity.
- **VehicleModelService**:
    - `getVehicleModelByBusinessId(long id)`: Retrieve model specs (deck type, fuel, etc.).

### Controllers (`ie.nta.central_data_hub.controller`)
- **EntityController**: Base path `/entities`.
    - `GET /`: All entities.
    - `GET /operators`: Filtered list of transport operators.
- **VehicleController**: Base path `/vehicles`.
    - `GET /{vehicleId}`: Specific vehicle details.
    - `GET /total-count`: System-wide vehicle statistics.
- **ContractController**: Base path `/contracts`.
- **VehicleModelController**: Base path `/vehicle-models`.

---

## 5. Status Management (Integer Mapping)
The project uses a strict pattern for statuses:
- `StatusEntity`: 1=ACTIVE, 2=INACTIVE.
- `StatusVehicle`: 1=IN_SERVICE, 2=OUT_OF_SERVICE.
- `StatusContract`: 1=APPROVE, 2=PENDING, etc.
- `RoleEntity`: 1=AUTHORITY, 2=OPERATOR, 3=SUPPLIER, 4=MANUFACTURER.

---

## 6. Guidelines for AI Collaborators
- **Consistency**: Always follow the existing Repository-Service-Controller pattern.
- **Documentation**: Provide KDoc/JavaDoc for all new public classes and methods.
- **Boilerplate**: Use the stateless getter/setter pattern for domain objects (Avoid adding Lombok for now unless explicitly requested).
- **MongoDB**: Use `spring.mongodb.*` properties in `application.properties`. Field names in Java should match `@Field` annotations exactly.
