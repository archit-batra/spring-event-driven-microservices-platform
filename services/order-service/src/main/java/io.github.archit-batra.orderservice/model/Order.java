package io.github.archit-batra.orderservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    private Double amount;

    public Order() {}

    public Order(String product, Double amount) {
        this.product = product;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public Double getAmount() {
        return amount;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}