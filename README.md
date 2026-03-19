# Central Data Hub - NTA

## Project Overview
**Central Data Hub** is a Spring Boot 4.0.3 application (Java 21) serving as the authoritative data aggregation layer for the National Transport Authority (NTA). It consolidates multi-source raw data points into a single MongoDB instance for cleaning, processing, and analytical reporting.

## Key Features
- **Data Consolidation**: Aggregates data from operators, authorities, and suppliers.
- **Hierarchical Domain Model**: Structured bounded contexts for Devices, Vehicles, and Assignments.
- **REST API**: Exposes endpoints for querying entities and vehicles.
- **MongoDB Integration**: Uses Spring Data MongoDB for high-performance data operations.

## Quick Start

### Prerequisites
- Java 21
- Maven 3.8+
- MongoDB Atlas (or local instance)

### Build and Run
```bash
# Build
./mvnw clean package

# Run
./mvnw spring-boot:run
```

## Documentation
- [AGENTS.md](AGENTS.md) - Detailed technical architecture and developer guidelines.
- [CHANGELOG.md](CHANGELOG.md) - History of changes and version information.
- [docs/MODIFICATIONS/README.md](docs/MODIFICATIONS/README.md) - Detailed modification logs.

## Current Status
- ✅ Core Domain Models
- ✅ MongoDB Configuration
- ✅ Entity & Vehicle Repositories
- ✅ Entity & Vehicle Services
- ✅ Entity & Vehicle Controllers
- ⏳ Contract & Depot Repositories
- ⏳ Device Context Implementation

---
**Maintained by**: Allynn Alvarico
**Last Updated**: 2026-03-19
