# System Architecture

This platform demonstrates an event-driven microservices architecture.

Services communicate asynchronously through Kafka topics.

## Event Flow

Client  
↓  
Order Service (REST API)  
↓  
Kafka Topic: order-events  
↓  
Payment Service (Consumer)  
↓  
Kafka Topic: payment-events  
↓  
Notification Service (Consumer)

## Benefits

- Loose coupling between services
- Asynchronous processing
- Independent scaling of services
- Fault-tolerant communication