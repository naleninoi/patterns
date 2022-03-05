package ru.gb.patterns.service.implementation;

import org.springframework.stereotype.Service;
import ru.gb.patterns.model.Customer;
import ru.gb.patterns.model.Order;
import ru.gb.patterns.service.NotificationService;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class OrderNotificationServiceImpl implements NotificationService<Customer, Order> {

    private Map<Customer, Set<Order>> listeners;

    @Override
    public void subscribe(Customer subscriber, Order event) {
        if (!listeners.containsKey(subscriber)) {
            listeners.put(subscriber, new HashSet<>());
        }
        listeners.get(subscriber).add(event);
    }

    @Override
    public void unsubscribe(Customer subscriber, Order event) {
        if (listeners.containsKey(subscriber)) {
            listeners.get(subscriber).remove(event);
        }
    }

    @Override
    public void notify(Customer subscriber, Order event) {
        if (listeners.containsKey(subscriber)) {
            subscriber.getUsers().forEach(
                    user -> System.out.printf("Ваш заказ находится в статусе %s", event.getStatus().toString())
            );
        }
    }

}
