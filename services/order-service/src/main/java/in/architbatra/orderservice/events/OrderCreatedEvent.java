package in.architbatra.orderservice.events;

public class OrderCreatedEvent {

    private Long orderId;
    private String product;
    private Double amount;

    public OrderCreatedEvent(Long orderId, String product, Double amount) {
        this.orderId = orderId;
        this.product = product;
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getProduct() {
        return product;
    }

    public Double getAmount() {
        return amount;
    }
}