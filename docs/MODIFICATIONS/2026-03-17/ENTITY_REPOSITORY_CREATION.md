# Modification: EntityRepository Interface Creation

**Date**: March 17, 2026  
**Version**: v0.0.2  
**Component**: Repository / Entity  
**Status**: ✅ Complete  
**AI Agent Recommendation**: Use as template for creating repositories for other domain entities

---

## Overview

Created the first Spring Data MongoDB repository interface for the Entity domain model. This establishes the repository pattern for the project and enables automatic CRUD operations and custom database queries without writing native MongoDB code.

This is the **first repository interface** in the project. Use this as the template for:
- ContractRepository
- DepotRepository
- DeviceRepository, DeviceModelRepository, DeviceTypeRepository
- VehicleRepository, VehicleModelRepository, VehicleCurrentProfileRepository
- DepotEntityRepository, EntityRoleRepository

---

## What Was Created

### File: `src/main/java/ie/nta/central_data_hub/repository/EntityRepository.java` (NEW)

```java
package ie.nta.central_data_hub.repository;

import ie.nta.central_data_hub.domain.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data MongoDB repository for Entity domain model.
 * Provides standard CRUD operations and custom query methods for Entity persistence.
 */
@Repository
public interface EntityRepository extends MongoRepository<Entity, String> {

    /**
     * Find an entity by its business identifier (entityId).
     *
     * @param entityId the business entity identifier
     * @return Optional containing the Entity if found, empty otherwise
     */
    Optional<Entity> findByEntityId(long entityId);

    /**
     * Find all entities by their status (statusId).
     *
     * @param statusId the status identifier (1=ACTIVE, 2=INACTIVE, 3=SUSPENDED)
     * @return list of entities with the specified status
     */
    java.util.List<Entity> findByStatusId(int statusId);

    /**
     * Find an entity by its country.
     *
     * @param country the country name
     * @return list of entities operating in the specified country
     */
    java.util.List<Entity> findByCountry(String country);

    /**
     * Check if an entity with the given entityId already exists.
     *
     * @param entityId the business entity identifier
     * @return true if entity exists, false otherwise
     */
    boolean existsByEntityId(long entityId);
}
```

---

## Package Structure

```
src/main/java/ie/nta/central_data_hub/
├── domain/
│   ├── Entity.java
│   ├── Contract.java
│   ├── Depot.java
│   ├── device/
│   └── vehicle/
├── repository/              # NEW PACKAGE
│   └── EntityRepository.java # NEW FILE
├── enums/
├── config/
└── CentralDataHubApplication.java
```

---

## Detailed Explanation

### Part 1: Class Declaration & Annotations

```java
@Repository
public interface EntityRepository extends MongoRepository<Entity, String> {
```

**`@Repository`**:
- Spring stereotype annotation for component scanning
- Marks this as a data access layer component
- Enables automatic exception translation from MongoDB to Spring exceptions
- Allows autowiring with `@Autowired` in service classes

**Extends `MongoRepository<Entity, String>`**:
- `Entity` = the domain type this repository manages
- `String` = the type of the primary key (`id` field type)
- MongoRepository provides auto-implemented CRUD methods:
  - `save(Entity)` — insert or update
  - `findById(String)` — find by MongoDB `_id`
  - `findAll()` — get all documents
  - `delete(Entity)` — delete a document
  - `deleteById(String)` — delete by ID
  - `existsById(String)` — check if document exists
  - `count()` — count total documents

---

### Part 2: Custom Query Methods

#### Method 1: `findByEntityId(long entityId)`

```java
Optional<Entity> findByEntityId(long entityId);
```

**What It Does**:
- Finds a single Entity by its business identifier (entityId)
- Returns `Optional<Entity>` (could be empty if not found)

**How Spring Data Works**:
- Parses method name: `findBy` + `EntityId`
- Automatically generates MongoDB query:
  ```javascript
  db.collection_entity.findOne({"entity_id": entityId})
  ```

**Usage Example**:
```java
@Service
public class EntityService {
    @Autowired
    private EntityRepository entityRepository;
    
    public Entity getEntityByBusinessId(long entityId) {
        return entityRepository.findByEntityId(entityId)
            .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }
}
```

**Why Return Optional**?
- Explicitly indicates the entity might not exist
- Forces developers to handle the "not found" case
- Avoids null pointer exceptions

---

#### Method 2: `findByStatusId(int statusId)`

```java
java.util.List<Entity> findByStatusId(int statusId);
```

**What It Does**:
- Finds all Entities with a specific status
- Returns a list (could be empty)

**MongoDB Query Generated**:
```javascript
db.collection_entity.find({"status_id": statusId})
```

**Status Values** (from StatusEntity enum):
- 1 = ACTIVE
- 2 = INACTIVE
- 3 = SUSPENDED

**Usage Example**:
```java
// Get all active entities
List<Entity> activeEntities = entityRepository.findByStatusId(1);

// Or using enum
List<Entity> activeEntities = entityRepository.findByStatusId(StatusEntity.ACTIVE.getStatusId());
```

---

#### Method 3: `findByCountry(String country)`

```java
java.util.List<Entity> findByCountry(String country);
```

**What It Does**:
- Finds all Entities operating in a specific country
- Returns a list

**MongoDB Query Generated**:
```javascript
db.collection_entity.find({"country": country})
```

**Usage Example**:
```java
List<Entity> irelandEntities = entityRepository.findByCountry("Ireland");
List<Entity> ukEntities = entityRepository.findByCountry("United Kingdom");
```

---

#### Method 4: `existsByEntityId(long entityId)`

```java
boolean existsByEntityId(long entityId);
```

**What It Does**:
- Checks if an Entity with given entityId exists
- Returns true/false (more efficient than findByEntityId for existence checks)

**MongoDB Query Generated**:
```javascript
db.collection_entity.countDocuments({"entity_id": entityId}) > 0
```

**Usage Example**:
```java
// Validation before creating new entity
if (entityRepository.existsByEntityId(123)) {
    throw new DuplicateEntityException("Entity with ID 123 already exists");
}
```

---

## Why These Custom Methods?

These 4 methods represent common use cases in the application:
1. **`findByEntityId`** — Look up an entity by its business key
2. **`findByStatusId`** — Find all entities in a specific state (reporting, filtering)
3. **`findByCountry`** — Find entities by location (geographical queries)
4. **`existsByEntityId`** — Validate before operations (prevent duplicates)

---

## How Spring Data Implements These Methods

Spring Data MongoDB uses **method name parsing** to generate queries automatically:

| Method Signature | MongoDB Query |
|------------------|---------------|
| `findByEntityId(long x)` | `find({"entity_id": x})` |
| `findByStatusId(int x)` | `find({"status_id": x})` |
| `findByCountry(String x)` | `find({"country": x})` |
| `existsByEntityId(long x)` | `countDocuments({"entity_id": x}) > 0` |

**Method Naming Convention**:
- `find...` — SELECT queries
- `By` — WHERE clause
- `FieldName` — maps to MongoDB field name
- `countBy...` — COUNT queries
- `existsBy...` — EXISTS checks
- `deleteBy...` — DELETE queries

---

## Injection & Usage in Services

### Service Class Example

```java
@Service
public class EntityService {
    
    @Autowired
    private EntityRepository entityRepository;
    
    // Create new entity
    public Entity createEntity(long entityId, String code, String name, 
                              String country, int statusId) {
        Entity entity = new Entity(entityId, code, name, country, statusId);
        return entityRepository.save(entity);
    }
    
    // Retrieve by business ID
    public Entity getEntity(long entityId) {
        return entityRepository.findByEntityId(entityId)
            .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }
    
    // List entities by status
    public List<Entity> getActiveEntities() {
        return entityRepository.findByStatusId(StatusEntity.ACTIVE.getStatusId());
    }
    
    // List entities by country
    public List<Entity> getEntitiesByCountry(String country) {
        return entityRepository.findByCountry(country);
    }
    
    // Check existence before operations
    public void validateUnique(long entityId) {
        if (entityRepository.existsByEntityId(entityId)) {
            throw new DuplicateEntityException("Entity already exists");
        }
    }
    
    // Update entity
    public Entity updateEntity(long entityId, String name) {
        Entity entity = getEntity(entityId);
        entity.setEntityName(name);
        return entityRepository.save(entity); // Update
    }
    
    // Delete entity
    public void deleteEntity(long entityId) {
        entityRepository.findByEntityId(entityId)
            .ifPresent(entityRepository::delete);
    }
}
```

---

## Inherited Methods from MongoRepository

These methods are **automatically implemented** and don't need to be defined:

```java
// CRUD Create
Entity entity = new Entity(...);
Entity saved = entityRepository.save(entity); // Returns saved entity with _id

// CRUD Read
Optional<Entity> found = entityRepository.findById("507f1f77bcf86cd799439011");
List<Entity> all = entityRepository.findAll();

// CRUD Update
entity.setEntityName("New Name");
entityRepository.save(entity);

// CRUD Delete
entityRepository.delete(entity);
entityRepository.deleteById("507f1f77bcf86cd799439011");

// Utility
boolean exists = entityRepository.existsById("507f1f77bcf86cd799439011");
long count = entityRepository.count();
```

---

## Testing Recommendations

- [ ] Test `save()` inserts new entity with auto-generated `_id`
- [ ] Test `save()` updates existing entity
- [ ] Test `findByEntityId()` returns correct entity or empty
- [ ] Test `findByStatusId()` returns all entities with status
- [ ] Test `findByStatusId()` returns empty list if no matches
- [ ] Test `findByCountry()` returns entities by country
- [ ] Test `findByCountry()` with country that has no entities
- [ ] Test `existsByEntityId()` returns true for existing, false for non-existing
- [ ] Test `findAll()` returns all entities
- [ ] Test `delete()` removes entity
- [ ] Test `count()` returns correct count

---

## Files Created

| File | Type | Status |
|------|------|--------|
| `src/main/java/ie/nta/central_data_hub/repository/EntityRepository.java` | Created | ✅ New Repository |

---

## Impact on Project Architecture

### Before
```
CentralDataHubApplication.java
├── config/MongoConfig.java (MongoDB setup)
└── domain/ (Models only)
    └── Entity.java (No persistence layer)
```

### After
```
CentralDataHubApplication.java
├── config/MongoConfig.java
├── domain/
│   └── Entity.java
├── repository/            # NEW
│   └── EntityRepository.java
└── (Future: services/, controllers/)
```

**Architecture Layers**:
1. **Domain Layer**: `Entity.java` (models)
2. **Repository Layer**: `EntityRepository.java` (data access) ← NEW
3. **Service Layer**: (TBD - will use repositories)
4. **Controller Layer**: (TBD - will expose REST endpoints)

---

## Next Steps

1. **Create repositories for other domain entities**:
   - Create `ContractRepository extends MongoRepository<Contract, String>`
   - Create `DepotRepository extends MongoRepository<Depot, String>`
   - Create `DeviceRepository extends MongoRepository<Device, String>`
   - Create `VehicleRepository extends MongoRepository<Vehicle, String>`
   - And so on...

2. **Apply same MongoDB enhancements to other domain classes** (see ENTITY_MONGODB_MAPPING.md):
   - Add `@Document` annotations
   - Add `@Id` and `@Field` annotations
   - Add `toString()`, `equals()`, `hashCode()`
   - Add JavaDoc

3. **Create Service layer** that injects repositories

4. **Create REST Controllers** that use services

---

## Best Practices Applied

✅ `@Repository` annotation for Spring scanning  
✅ Clear method naming following Spring Data conventions  
✅ Return `Optional` for queries that might not find results  
✅ Comprehensive JavaDoc comments  
✅ Typed queries (not raw strings)  
✅ Separation of concerns (repository handles data access)

---

## References

- Spring Data MongoDB Repository Documentation: https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#repositories
- MongoRepository Interface: https://docs.spring.io/spring-data/mongodb/docs/current/api/org/springframework/data/mongodb/repository/MongoRepository.html
- Query Methods: https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#repositories.query-methods-details

---

**Last Updated**: March 17, 2026  
**By**: AI Code Agent  
**Status**: ✅ Complete & Ready for Use

