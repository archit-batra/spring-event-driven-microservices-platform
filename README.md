# Spring Event Driven Microservices Platform

A production-style backend platform built using **Spring Boot and Kafka** demonstrating event-driven microservices architecture, asynchronous communication and scalable backend design.

The system models an order processing pipeline where services communicate through events instead of synchronous API calls.

---

## Architecture Overview

* **Order Service**
  Handles REST APIs for order creation and publishes order events.

* **Payment Service**
  Consumes order events and processes payments asynchronously.

* **Notification Service**
  Consumes payment events and triggers notifications.

Event communication is handled through Kafka topics.

---

## Architecture Flow

Client
↓
Order Service
↓
Kafka (order-events topic)
↓
Payment Service
↓
Kafka (payment-events topic)
↓
Notification Service

---

## Technology Stack

* Java 21
* Spring Boot 3.3.2
* Apache Kafka
* PostgreSQL
* Docker
* REST APIs
* Maven

---

## Project Structure

```
services/
  order-service           # Handles order APIs
  payment-service         # Processes payment events
  notification-service    # Handles notification events

infrastructure/
  docker/                 # Docker configuration

docs/
  architecture.md         # System architecture documentation
```

---

## Running PostgreSQL (Docker)

Start PostgreSQL using Docker:

```bash
docker-compose up -d
```

Database configuration:

* Host: localhost
* Port: 5432
* Database: orders
* Username: postgres
* Password: postgres

To stop the database:

```bash
docker-compose down
```

---

## Running the Order Service

Navigate to the service:

```bash
cd services/order-service
```

Run the application:

```bash
mvn spring-boot:run
```

The service will start on:

```
http://localhost:8080
```

---

## API Endpoints

### Create Order

```bash
POST /orders
```

Example request:

```json
{
  "product": "iPhone",
  "amount": 1000
}
```

---

### Get Order

```bash
GET /orders/{id}
```

---

## Configuration

The application supports environment-based configuration:

```yaml
spring:
  datasource:
    url: ${DB_URL:jdbc:postgresql://localhost:5432/orders}
    username: ${DB_USERNAME:postgres}
    password: ${DB_PASSWORD:postgres}
```

---

## Goals

This project demonstrates:

* Event-driven microservices architecture
* Kafka-based service communication
* Asynchronous processing patterns
* Scalable backend design
* Containerized microservices deployment