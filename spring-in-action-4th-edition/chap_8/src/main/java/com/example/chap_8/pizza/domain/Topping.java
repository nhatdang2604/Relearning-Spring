package com.example.chap_8.pizza.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public enum Topping implements Serializable {

    //names of topping
    PEPPERONI,
    SAUSAGE,
    HAMBUGER,
    MUSHROOM;

    public static List<Topping> asList() {
        Topping[] toppings = Topping.values();
        return Arrays.asList(toppings);
    }

    @Override
    public String toString() {
        return this.name()
                .toLowerCase()
                .replace("_", " ");
    }
}
