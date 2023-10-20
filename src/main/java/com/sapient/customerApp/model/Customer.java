package com.sapient.customerApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@Entity
public class Customer {
//    @Id
//    @GeneratedValue()
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //    @Column
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
