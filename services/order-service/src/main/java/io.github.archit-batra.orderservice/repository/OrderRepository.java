package io.github.archit-batra.orderservice.repository;

import io.github.archit-batra.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}