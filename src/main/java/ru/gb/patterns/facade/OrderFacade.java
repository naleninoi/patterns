package ru.gb.patterns.facade;

import ru.gb.patterns.model.Order;

import java.text.ParseException;
import java.util.List;

public interface OrderFacade {

    List<Order> getOrders(String dateFrom, String dateTo, Long warehouseId, Long customerId) throws ParseException;

}
