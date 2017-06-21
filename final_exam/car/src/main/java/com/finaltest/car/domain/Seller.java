package com.finaltest.car.domain;

import javax.persistence.*;

/**
 * Created by Alone Demon on 18/06/2017.
 */
@Entity
@Table(name = "seller")
public class Seller{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int age;
    private int solds_cars;
    private String firstname;
    private String lastname;
    private int ci;

    public long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getSolds_cars() {
        return solds_cars;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSolds_cars(int solds_cars) {
        this.solds_cars = solds_cars;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }
}
