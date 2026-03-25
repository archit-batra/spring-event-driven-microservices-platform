package in.architbatra.notificationservice.events;

public class PaymentCompletedEvent {

    private Long orderId;
    private String status;

    public PaymentCompletedEvent() {}

    public Long getOrderId() { return orderId; }
    public String getStatus() { return status; }
}