package in.architbatra.orderservice.events;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventProducer {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public OrderEventProducer(KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishOrderCreatedEvent(OrderCreatedEvent event) {
        System.out.println("Publishing OrderCreatedEvent to Kafka: orderId=" + event.getOrderId());
        kafkaTemplate.send("order-events", event)
            .whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Event sent successfully to Kafka for orderId=" + event.getOrderId());
                } else {
                    System.err.println("Failed to send event: " + ex.getMessage());
                }
            });
    }
}