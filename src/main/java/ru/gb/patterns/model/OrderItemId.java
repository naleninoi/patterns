package ru.gb.patterns.model;

import java.io.Serializable;
import java.util.Objects;

public class OrderItemId implements Serializable {

    private Long order;
    private Long balloon;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderItemId that = (OrderItemId) o;
        return Objects.equals(order, that.order) && Objects.equals(balloon, that.balloon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, balloon);
    }

}
