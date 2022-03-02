package ru.gb.patterns.facade.implementation;

import org.springframework.stereotype.Service;
import ru.gb.patterns.facade.OrderFacade;
import ru.gb.patterns.model.Order;
import ru.gb.patterns.model.User;
import ru.gb.patterns.service.OrderService;
import ru.gb.patterns.service.SecurityService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderFacadeImpl implements OrderFacade {

    private final OrderService orderService;
    private final SecurityService securityService;

    public OrderFacadeImpl(OrderService orderService, SecurityService securityService) {
        this.orderService = orderService;
        this.securityService = securityService;
    }

    @Override
    public List<Order> getOrders(String dateFrom, String dateTo, Long warehouseId, Long customerId) throws ParseException {
        Date dateFromValue = !dateFrom.equals("") ? new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom) : null;
        Date dateToValue = !dateTo.equals("") ? new SimpleDateFormat("yyyy-MM-dd").parse(dateTo) : null;
        User currentUser = securityService.getCurrentUser();
        if (currentUser.getWarehouse() != null) {
            warehouseId = currentUser.getWarehouse().getId();
        }
        if (currentUser.getCustomer() != null) {
            customerId = currentUser.getCustomer().getId();
        }
        return orderService.findAll(dateFromValue, dateToValue, warehouseId, customerId);
    }

}
