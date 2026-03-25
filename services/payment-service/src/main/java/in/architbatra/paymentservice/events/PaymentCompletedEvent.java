package in.architbatra.paymentservice.events;

public class PaymentCompletedEvent {

    private Long orderId;
    private String status;

    public PaymentCompletedEvent() {}

    public PaymentCompletedEvent(Long orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public Long getOrderId() { return orderId; }
    public String getStatus() { return status; }
}