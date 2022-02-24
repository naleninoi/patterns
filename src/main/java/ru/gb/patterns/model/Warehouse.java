package ru.gb.patterns.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "warehouses")
public class Warehouse extends BaseEntity{

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    private List<Customer> customers;

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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public BalloonHolder getBalloonHolder() {
        return balloonHolder;
    }

    public void setBalloonHolder(BalloonHolder balloonHolder) {
        this.balloonHolder = balloonHolder;
    }

}
