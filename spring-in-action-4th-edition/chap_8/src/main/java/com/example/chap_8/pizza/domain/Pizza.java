package com.example.chap_8.pizza.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Pizza implements Serializable {

    private PizzaSize size;
    private List<Topping> toppings;

    public Pizza() {
        toppings = new ArrayList<>();
        size = PizzaSize.LARGE;
    }

    //Setters with string value of enum
    public void setSize(String sizeString) {
        this.size = PizzaSize.valueOf(sizeString);
    }

    public void setTopping(String[] toppingStrings) {
        toppings = Arrays
                .stream(toppingStrings)
                .map(Topping::valueOf)
                .collect(Collectors.toList());
    }

}
