package ru.gb.patterns.enumeration;

public enum OrderStatus {

    NOT_SET(""),

    NEW("NEW"),
    PROCESSING("PROCESSING"),
    ON_WAY("ON_WAY"),
    DELIVERED("DELIVERED"),
    CANCELLED("CANCELLED"),
    REFUSED("REFUSED")
    ;

    private final String orderStatusName;

    OrderStatus(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    @Override
    public String toString() {
        return orderStatusName;
    }

}
