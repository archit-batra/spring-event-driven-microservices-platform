# Spring Event Driven Microservices Platform

A production-style backend platform built using **Spring Boot and Kafka** demonstrating event-driven microservices architecture, asynchronous communication and scalable backend design.

The system models an order processing pipeline where services communicate through events instead of synchronous API calls.

---

## Architecture Overview

Order Service  
Handles REST APIs for order creation and publishes order events.

Payment Service  
Consumes order events and processes payments asynchronously.

Notification Service  
Consumes payment events and triggers notifications.

Event communication is handled through Kafka topics.

---

## Technology Stack

- Java 21
- Spring Boot 3.3
- Apache Kafka
- PostgreSQL
- Docker
- REST APIs
- Maven

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

## Project Structure

order-service – handles order APIs  
payment-service – processes payment events  
notification-service – handles notification events

---

## Goals

This project demonstrates:

- Event-driven microservices architecture
- Kafka-based service communication
- Asynchronous processing patterns
- Scalable backend design
- Containerized microservices deployment