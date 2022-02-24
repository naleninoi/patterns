package ru.gb.patterns.service.implementation;

import org.springframework.stereotype.Service;
import ru.gb.patterns.model.Order;
import ru.gb.patterns.repository.OrderRepository;
import ru.gb.patterns.service.OrderService;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAllByDeletedIsFalse();
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(Order order) {
        order.setDeleted(true);
        orderRepository.save(order);
    }

}
