package ru.gb.patterns.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.patterns.model.Order;
import ru.gb.patterns.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders")
public class OrderRestController {

    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        Optional<Order> optionalOrder = orderService.findById(id);
        if (optionalOrder.isPresent()) {
            return ResponseEntity.ok(optionalOrder.get());
        } else {
            return new ResponseEntity<>("Cannot find order with id " + id, HttpStatus.NOT_FOUND);
        }
    }

}
