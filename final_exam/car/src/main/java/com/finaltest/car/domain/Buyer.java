package com.finaltest.car.domain;

import javax.persistence.*;

/**
 * Created by Alone Demon on 18/06/2017.
 */
@Entity
@Table(name = "buyer")
public class Buyer{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String proffession;
    private long celular;
    private String firstname;
    private String lastname;
    private int ci;

    public long getId() {
        return id;
    }

    public String getProffession() {
        return proffession;
    }

    public long getCelular() {
        return celular;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProffession(String proffession) {
        this.proffession = proffession;
    }

    public void setCelular(long celular) {
        this.celular = celular;
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
