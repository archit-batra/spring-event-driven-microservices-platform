package in.architbatra.paymentservice.events;

import in.architbatra.paymentservice.events.OrderCreatedEvent;
import in.architbatra.paymentservice.events.PaymentCompletedEvent;
import in.architbatra.paymentservice.events.PaymentEventProducer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventConsumer {

    private final PaymentEventProducer producer;

    public PaymentEventConsumer(PaymentEventProducer producer) {
        this.producer = producer;
    }

    @KafkaListener(topics = "order-events", groupId = "payment-group")
    public void consume(OrderCreatedEvent event) {

        System.out.println("Received OrderCreatedEvent: orderId=" + event.getOrderId());

        // simulate payment processing
        System.out.println("Processing payment...");

        // publish next event
        PaymentCompletedEvent paymentEvent =
            new PaymentCompletedEvent(event.getOrderId(), "SUCCESS");

        producer.publishPaymentCompletedEvent(paymentEvent);
    }
}