package com.example.chap_8.pizza.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Customer implements Serializable {

    //Id generator
    private static Integer NEXT_ID = 0;

    private Integer id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;

    public Customer() {
        id = ++NEXT_ID;
    }

    public Customer(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        id = ++NEXT_ID;
    }
}
