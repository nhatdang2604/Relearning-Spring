package com.example.chap_8.pizza.service;

public class CustomerNotFoundException extends Exception {

    public CustomerNotFoundException() {
        super();
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
