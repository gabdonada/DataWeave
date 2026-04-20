# DataWeave

## Overview

**DataWeave** is a lightweight, real-time data ingestion and schema management platform built with Java 21.

It enables clients to define datasets dynamically, automatically provision corresponding SQL structures, and ingest structured data in near real-time. The platform is designed to handle evolving data models while maintaining strong typing and query capabilities through a relational database.

---

## Key Capabilities

* **Dynamic Schema Definition**
  Define datasets at runtime with custom fields and types.

* **Automated Table Provisioning**
  SQL tables are generated and created automatically based on dataset definitions.

* **Real-Time Data Ingestion**
  Accept and persist data immediately after schema creation.

* **Strong Typing with Flexibility**
  Enforces field types while allowing schema evolution.

* **Extensible Architecture**
  Designed to support future enhancements such as external ingestion, analytics, and AI-driven insights.

---

## Architecture

```text
API Layer → Service Layer → SQL Builder → Schema Manager → Database
```

### Components

* **API Layer**
  Exposes REST endpoints for dataset management and data ingestion.

* **Service Layer**
  Coordinates business operations such as dataset creation and ingestion workflows.

* **SQL Builder**
  Generates SQL statements dynamically based on dataset definitions.

* **Schema Manager**
  Executes SQL statements and manages database interactions.

* **Database Layer**
  Stores dynamically created tables and ingested data.

---

## Data Model

### Dataset

Represents a logical collection of structured data defined at runtime.

### FieldDefinition

Defines individual fields within a dataset, including name and type.

### FieldType

Enumerates supported data types:

* STRING
* NUMBER
* DATETIME

---

## Current Scope

The current implementation focuses on:

* Dataset definition
* Dynamic SQL generation
* Automated table creation

---

## Roadmap

### Short-Term

* Data insertion into dynamically created tables
* Input validation against dataset schemas
* REST API for dataset management

---

### Mid-Term

* External data ingestion via HTTP endpoints
* Concurrent ingestion handling
* Error handling and retry mechanisms

---

### Long-Term

* Query capabilities (filtering and aggregation)
* Dataset evolution support (schema updates)
* Integration with analytics and AI services

---

## Design Principles

* **Modularity** — clear separation between domain, service, and infrastructure layers
* **Scalability** — designed to handle concurrent ingestion workloads
* **Extensibility** — architecture supports incremental feature expansion
* **Maintainability** — emphasis on clean boundaries and testable components

---

## Technology Stack

* Java 21
* Relational Database (initially in-memory, pluggable for production systems)
* RESTful APIs

---

## Getting Started

1. Define a dataset with desired fields
2. Submit the dataset definition to the platform
3. DataWeave provisions the corresponding database table
4. Begin ingesting data into the dataset

---

## Status

Active development — core schema and provisioning capabilities in progress.

---

## License

TBD
