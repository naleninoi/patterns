package ru.gb.patterns.service;

import ru.gb.patterns.model.Order;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<Order> findById(Long id);

    List<Order> findAll(Date dateFrom, Date dateTo, Long warehouseId, Long customerId);

    void save(Order order);

    void delete(Order order);

}
