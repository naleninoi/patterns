package ru.gb.patterns.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    private Warehouse warehouse;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "holder_id", referencedColumnName = "id")
    private BalloonHolder balloonHolder;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public BalloonHolder getBalloonHolder() {
        return balloonHolder;
    }

    public void setBalloonHolder(BalloonHolder balloonHolder) {
        this.balloonHolder = balloonHolder;
    }

}
