# CHANGELOG - Central Data Hub

All notable changes to the Central Data Hub project are documented here. This document helps AI agents track code modifications, understand the evolution of the codebase, and maintain consistency with established patterns.

**Format**: [Date] | [Version] | [Type] | [Component] | [Description]

---

## [2026-03-17] | v0.0.2 | Enhancement | Entity Domain & Repository Layer

### Overview
Completed Entity domain model with full MongoDB mapping annotations and created the first repository layer for data persistence operations.

### Changes Made

#### 1. **Entity.java** - MongoDB Domain Model Enhancement
**File**: `src/main/java/ie/nta/central_data_hub/domain/Entity.java`

**What Changed**:
- ✅ Added `@Document(collection = "collection_entity")` annotation
- ✅ Added `@Id` annotation on `id` field (maps to MongoDB `_id`)
- ✅ Added `@Field` annotations on all fields with explicit MongoDB field names:
  - `@Field("entity_id")` for `entityId`
  - `@Field("entity_code")` for `entityCode`
  - `@Field("entity_name")` for `entityName`
  - `@Field("country")` for `country`
  - `@Field("status_id")` for `statusId`
- ✅ Added `getId()` and `setId()` methods (critical for MongoDB operations)
- ✅ Added `toString()` method for logging and debugging
- ✅ Added `equals()` method for object comparison and collections
- ✅ Added `hashCode()` method for use in Sets and Maps
- ✅ Added comprehensive JavaDoc comments on class and critical fields
- ✅ Added `entityCode` field to domain model

**Why This Change**:
- MongoDB deserialization requires explicit mapping annotations
- `@Id` field is essential for insert/update/delete operations
- `equals()` and `hashCode()` are Java best practices for domain objects
- `toString()` aids in debugging and logging
- JavaDoc comments help AI agents understand field purposes

**MongoDB Impact**:
- Documents now properly serialize/deserialize from MongoDB
- Field names in MongoDB match domain objects via `@Field` annotations
- Dual identity system: `id` (MongoDB `_id`) and `entityId` (business key)

**Code Pattern Used**:
- Followed project convention: explicit getter/setter pattern (no Lombok)
- Maintained no-arg constructor for MongoDB deserialization
- Kept parameterized constructor for object creation

---

#### 2. **EntityRepository.java** - NEW Spring Data MongoDB Repository
**File**: `src/main/java/ie/nta/central_data_hub/repository/EntityRepository.java` (NEW FILE)

**What Was Created**:
- ✅ Created repository package: `ie.nta.central_data_hub.repository`
- ✅ Created EntityRepository interface extending `MongoRepository<Entity, String>`
- ✅ Added `@Repository` annotation for Spring component scanning
- ✅ Implemented 4 custom query methods with JavaDoc:
  - `findByEntityId(long entityId)` — find entity by business ID
  - `findByStatusId(int statusId)` — find all entities with specific status
  - `findByCountry(String country)` — find entities by country
  - `existsByEntityId(long entityId)` — check if entity exists

**Why This Change**:
- Spring Data MongoDB repositories provide automatic CRUD implementations
- Custom query methods enable domain-specific database queries
- `@Repository` enables autowiring into services
- Separates data access logic from business logic

**Auto-Generated Methods** (provided by MongoRepository):
- `save(Entity)` — insert or update entity
- `findById(String)` — find by MongoDB `_id`
- `findAll()` — retrieve all entities
- `delete(Entity)` — remove entity
- `deleteById(String)` — remove by ID
- `existsById(String)` — check existence
- `count()` — get total document count

**Usage Pattern**:
```java
@Service
public class EntityService {
    @Autowired
    private EntityRepository entityRepository;
    
    public Entity createEntity(...) {
        Entity entity = new Entity(...);
        return entityRepository.save(entity); // Persists to MongoDB
    }
}
```

**MongoDB Queries Generated**:
- `findByEntityId()` → `db.collection_entity.findOne({"entity_id": value})`
- `findByStatusId()` → `db.collection_entity.find({"status_id": value})`
- `findByCountry()` → `db.collection_entity.find({"country": value})`

---

### MongoDB Collection Schema Impact

**Collection Name**: `collection_entity`

**Document Structure** (example):
```json
{
  "_id": "507f1f77bcf86cd799439011",
  "entity_id": 12345,
  "entity_code": "OP_001",
  "entity_name": "Dublin Bus",
  "country": "Ireland",
  "status_id": 1
}
```

---

### Files Modified/Created

| File | Type | Status |
|------|------|--------|
| `domain/Entity.java` | Modified | Enhanced with MongoDB annotations + helper methods |
| `repository/EntityRepository.java` | Created | Spring Data MongoDB repository interface |

---

### Backwards Compatibility

✅ **Fully Backward Compatible**
- No breaking changes to existing Entity constructor
- No changes to existing getter/setter method signatures
- New methods are additions only

---

### Testing Recommendations

- [ ] Test Entity serialization to/from MongoDB
- [ ] Test EntityRepository.save() creates/updates correctly
- [ ] Test each custom query method returns correct results
- [ ] Test equals/hashCode consistency
- [ ] Verify `_id` is auto-generated on save

---

### Next Steps for AI Agents

1. **Create repositories for other domain entities**:
   - ContractRepository
   - DepotRepository
   - DeviceRepository, DeviceModelRepository, DeviceTypeRepository
   - VehicleRepository, VehicleModelRepository, VehicleCurrentProfileRepository
   - DepotEntityRepository, EntityRoleRepository

2. **Create Service layer classes** that inject and use repositories

3. **Add REST Controller endpoints** to expose CRUD operations

4. **Add validation annotations** to domain fields (@NotNull, @NotEmpty, etc.)

---

### Configuration Requirements

✅ Already configured in this project:
- `MongoConfig.java` — MongoDB client setup
- `application.properties` — MongoDB Atlas connection string
- `pom.xml` — spring-boot-starter-data-mongodb dependency

---

## [2026-03-17] | v0.0.1 | Initial | Project Setup

### Overview
Initial project setup with domain models, enums, and MongoDB configuration.

**Completed**:
- ✅ Spring Boot 4.0.3 application structure
- ✅ Domain layer with hierarchical bounded contexts (device, vehicle, assignment)
- ✅ Status management enums (StatusEntity, StatusVehicle, StatusDeviceCurrent, StatusConditionDevice, StatusContract, RoleEntity)
- ✅ MongoDB Atlas configuration
- ✅ Startup diagnostics bean for collection discovery
- ✅ AGENTS.md documentation

**Status**: Foundation laid, repository layer pending

---

## How AI Agents Should Use This Changelog

1. **When making code changes**: Update this CHANGELOG.md with a new section
2. **When reviewing changes**: Check CHANGELOG.md to understand what was modified and why
3. **Before refactoring**: Review past changes to maintain consistency with patterns
4. **When onboarding new features**: Look at similar changes in changelog for examples

### Changelog Entry Template

```markdown
## [DATE] | vX.X.X | [Type] | [Component]

### Overview
Brief summary of what was done and why.

### Changes Made

#### [Number]. **[Filename]** - [Brief Description]
**File**: `path/to/file.java`

**What Changed**:
- ✅ Change 1
- ✅ Change 2

**Why This Change**:
- Reason 1
- Reason 2

**Impact**:
- What this affects
```

---

**Last Updated**: March 17, 2026  
**Maintained By**: AI Code Agents  
**Project**: Central Data Hub (NTA)

---

## [2026-03-18] | v0.0.3 | Fix | MongoDB Connection & Configuration Layer

### Overview
Resolved a series of cascading configuration issues that prevented the application from connecting
to the correct MongoDB database (`Central_Data_Hub_Concept`) and returning entity data. Root cause
was a hardcoded database name in `MongoConfig.java` that overrode all `application.properties` settings.

### Changes Made

#### 1. **MongoConfig.java** - Database Name Decoupled from Hardcode
**File**: `src/main/java/ie/nta/central_data_hub/config/MongoConfig.java`

**What Changed**:
- ✅ Replaced hardcoded `return "TestDatabase"` in `getDatabaseName()` with `@Value`-injected property
- ✅ Added `@Value("${spring.mongodb.database}")` field `databaseName`
- ✅ `getDatabaseName()` now returns `databaseName` from `application.properties`

**Why This Change**:
- `getDatabaseName()` in `AbstractMongoClientConfiguration` takes highest priority over all property files
- Hardcoded `"TestDatabase"` silently overrode every `application.properties` change
- Using `@Value` allows environment-specific database switching without modifying Java code

**Before**:
```java
@Override
protected String getDatabaseName() {
    return "TestDatabase";
}
@Value("${spring.mongodb.database}")
private String databaseName;

@Override
protected String getDatabaseName() {
    return databaseName;
}
```

