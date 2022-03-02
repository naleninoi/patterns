package ru.gb.patterns.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.patterns.enumeration.OrderStatus;
import ru.gb.patterns.facade.OrderFacade;
import ru.gb.patterns.model.Order;
import ru.gb.patterns.service.OrderService;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders")
public class OrderRestController {

    private final OrderService orderService;
    private final OrderFacade orderFacade;

    public OrderRestController(OrderService orderService, OrderFacade orderFacade) {
        this.orderService = orderService;
        this.orderFacade = orderFacade;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(
            @RequestParam(required = false, defaultValue = "") String dateFrom,
            @RequestParam(required = false, defaultValue = "") String dateTo,
            @RequestParam(required = false, defaultValue = "-1") Long warehouseId,
            @RequestParam(required = false, defaultValue = "-1") Long customerId
    ) throws ParseException {
        return ResponseEntity.ok(orderFacade.getOrders(dateFrom, dateTo, warehouseId, customerId));
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
