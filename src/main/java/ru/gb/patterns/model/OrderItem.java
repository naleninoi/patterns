package ru.gb.patterns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
@IdClass(OrderItemId.class)
public class OrderItem {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name="order_id", referencedColumnName = "id")
    private Order order;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name="balloon_id", referencedColumnName = "id")
    private Balloon balloon;

    @Column(name = "quantity")
    private int quantity;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Balloon getBalloon() {
        return balloon;
    }

    public void setBalloon(Balloon balloon) {
        this.balloon = balloon;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
