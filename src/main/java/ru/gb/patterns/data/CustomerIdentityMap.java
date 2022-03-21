package ru.gb.patterns.data;

import ru.gb.patterns.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerIdentityMap {
    private static CustomerIdentityMap instance = new CustomerIdentityMap();

    private Map<Long, Customer> customerMap = new HashMap<>();

    public static Customer getCustomer(Long id) {
        return instance.customerMap.get(id);
    }

    public static void addCustomer(Customer customer) {
        instance.customerMap.put(customer.getId(), customer);
    }

    public static boolean contains(Customer customer) {
        return instance.customerMap.containsKey(customer.getId());
    }

}
