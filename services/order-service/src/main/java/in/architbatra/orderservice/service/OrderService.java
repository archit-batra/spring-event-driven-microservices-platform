package in.architbatra.orderservice.service;

import in.architbatra.orderservice.events.OrderCreatedEvent;
import in.architbatra.orderservice.events.OrderEventProducer;
import in.architbatra.orderservice.model.Order;
import in.architbatra.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderEventProducer eventProducer;

    public OrderService(OrderRepository orderRepository, OrderEventProducer eventProducer) {
        this.orderRepository = orderRepository;
        this.eventProducer = eventProducer;
    }

    public Order createOrder(Order order) {
        Order saved = orderRepository.save(order);

        OrderCreatedEvent event = new OrderCreatedEvent(
            saved.getId(),
            saved.getProduct(),
            saved.getAmount()
        );

        eventProducer.publishOrderCreatedEvent(event);

        return saved;
    }

    public Optional<Order> getOrder(Long id) {
        return orderRepository.findById(id);
    }
}