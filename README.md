# Spring Event Driven Microservices Platform

A production-style backend platform built using **Spring Boot and Kafka** demonstrating event-driven microservices architecture, asynchronous communication, and scalable backend design.

The system models an order processing pipeline where services communicate through events instead of synchronous API calls.

---

## Architecture Overview

* **Order Service**
  Handles REST APIs for order creation and publishes order events.

* **Payment Service**
  Consumes order events, processes payments, and publishes payment events.

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
  payment-service         # Consumes order events and publishes payment events
  notification-service    # Consumes payment events

infrastructure/
  docker/                 # Docker configuration

docs/
  architecture.md         # System architecture documentation
```

---

## Running Infrastructure (Docker)

Start PostgreSQL and Kafka:

```bash
docker-compose up -d
```

---

### PostgreSQL Configuration

* Host: localhost
* Port: 5432
* Database: orders
* Username: postgres
* Password: postgres

---

### Kafka Configuration

* Host: localhost
* Port: 9092

---

## Kafka Topics

The application uses the following topics:

* `order-events`
* `payment-events`

Topics may be auto-created in development.
In production, topics should be created explicitly.

---

## Verifying Kafka Topics

```bash
docker exec -it kafka /opt/kafka/bin/kafka-topics.sh \
--list \
--bootstrap-server localhost:9092
```

---

## Running the Services

### 1. Start Notification Service

```bash
cd services/notification-service
mvn spring-boot:run
```

Runs on:

```
http://localhost:8082
```

---

### 2. Start Payment Service

```bash
cd services/payment-service
mvn spring-boot:run
```

Runs on:

```
http://localhost:8081
```

---

### 3. Start Order Service

```bash
cd services/order-service
mvn spring-boot:run
```

Runs on:

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

## End-to-End Flow Test

1. Start infrastructure using Docker
2. Start Notification Service
3. Start Payment Service
4. Start Order Service

Create an order:

```bash
curl -X POST http://localhost:8080/orders \
-H "Content-Type: application/json" \
-d '{"product":"iPhone","amount":1000}'
```

---

### Expected Behavior

* Order is stored in PostgreSQL
* Order event is published to Kafka (`order-events`)
* Payment Service consumes the event
* Payment event is published to Kafka (`payment-events`)
* Notification Service consumes the event
* Notification is triggered

---

## Configuration

The application supports environment-based configuration:

```yaml
spring:
  datasource:
    url: ${DB_URL:jdbc:postgresql://localhost:5432/orders}
    username: ${DB_USERNAME:postgres}
    password: ${DB_PASSWORD:postgres}

  kafka:
    bootstrap-servers: ${KAFKA_BOOTSTRAP_SERVERS:localhost:9092}
```

---

## Goals

This project demonstrates:

* Event-driven microservices architecture
* Kafka-based service communication
* Asynchronous processing patterns
* Scalable backend design
* Containerized microservices deployment

---

## What I'd Add Next

- Dead-letter queue for failed message processing (currently retries indefinitely on malformed events)
- Idempotency keys to handle duplicate event delivery safely
- Distributed tracing across services (e.g. Zipkin/Jaeger) for request flow visibility
- Integration tests covering the full order → payment → notification flow