package in.architbatra.notificationservice.consumer;

import in.architbatra.notificationservice.events.PaymentCompletedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventConsumer {

    @KafkaListener(topics = "payment-events", groupId = "notification-group")
    public void consume(PaymentCompletedEvent event) {

        System.out.println("Notification Service received payment event for orderId=" + event.getOrderId());

        System.out.println("Sending notification for successful payment...");
    }
}