package in.architbatra.paymentservice.consumer;

import in.architbatra.paymentservice.events.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventConsumer {

    @KafkaListener(topics = "order-events", groupId = "payment-group")
    public void consume(OrderCreatedEvent event) {

        System.out.println("Received OrderCreatedEvent in Payment Service: orderId=" + event.getOrderId());

        // simulate payment processing
        System.out.println("Processing payment for orderId=" + event.getOrderId());
    }
}