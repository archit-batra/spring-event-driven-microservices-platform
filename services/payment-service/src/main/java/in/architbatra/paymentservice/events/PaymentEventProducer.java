package in.architbatra.paymentservice.events;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventProducer {

    private final KafkaTemplate<String, PaymentCompletedEvent> kafkaTemplate;

    public PaymentEventProducer(KafkaTemplate<String, PaymentCompletedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishPaymentCompletedEvent(PaymentCompletedEvent event) {

        System.out.println("Publishing PaymentCompletedEvent for orderId=" + event.getOrderId());

        kafkaTemplate.send("payment-events", event)
            .whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Payment event sent successfully!");
                } else {
                    System.err.println("Failed to send payment event: " + ex.getMessage());
                }
            });
    }
}