package com.example.chap_8.pizza.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Order implements Serializable {

    private static final long serialVersionUID = 2L;

    private Customer customer;
    private List<Pizza> pizzas;
    private Payment payment;

    public Order() {
        pizzas = new ArrayList<>();
        customer = new Customer();
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public float getTotal() {
        return 0.0f;
    }

}
