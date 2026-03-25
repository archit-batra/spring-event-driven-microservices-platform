package in.architbatra.paymentservice.events;

public class OrderCreatedEvent {

    private Long orderId;
    private String product;
    private Double amount;

    public OrderCreatedEvent() {}

    public Long getOrderId() { return orderId; }
    public String getProduct() { return product; }
    public Double getAmount() { return amount; }
}