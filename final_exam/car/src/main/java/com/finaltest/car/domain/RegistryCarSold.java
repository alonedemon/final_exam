package com.finaltest.car.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alone Demon on 18/06/2017.
 */
@Entity
@Table(name = "registry_car_sold")
public class RegistryCarSold {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date sell_date;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Seller seller;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Buyer buyer;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Car car;

    public long getId() {
        return id;
    }

    public Date getSell_date() {
        return sell_date;
    }

    public Seller getSeller() {
        return seller;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Car getCar() {
        return car;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSell_date(Date sell_date) {
        this.sell_date = sell_date;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
