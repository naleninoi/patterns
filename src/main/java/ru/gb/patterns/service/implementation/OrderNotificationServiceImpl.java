package ru.gb.patterns.service.implementation;

import org.springframework.stereotype.Service;
import ru.gb.patterns.model.Customer;
import ru.gb.patterns.model.Order;
import ru.gb.patterns.service.NotificationService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class OrderNotificationServiceImpl implements NotificationService<Customer, Order> {

    private final Map<Customer, Set<Order>> LISTENERS = new HashMap<>();

    @Override
    public void subscribe(Customer subscriber, Order event) {
        if (!LISTENERS.containsKey(subscriber)) {
            LISTENERS.put(subscriber, new HashSet<>());
        }
        LISTENERS.get(subscriber).add(event);
    }

    @Override
    public void unsubscribe(Customer subscriber, Order event) {
        if (LISTENERS.containsKey(subscriber)) {
            LISTENERS.get(subscriber).remove(event);
        }
    }

    @Override
    public void notify(Customer subscriber, Order event) {
        if (LISTENERS.containsKey(subscriber)) {
            subscriber.getUsers().forEach(
                    user -> System.out.printf("Ваш заказ находится в статусе %s", event.getStatus().toString())
            );
        }
    }

    @Override
    public void notifyAll(Order event) {
        LISTENERS.forEach((customer, orders) -> {
            if (orders.contains(event)) {
                System.out.printf("Клиент %d оповещен о изменениях в заказе с номером %d", customer.getId(), event.getId());
            }
        });
    }

}
