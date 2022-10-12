package com.example.chap_8.pizza.domain;

import java.io.Serializable;

public enum PizzaSize implements Serializable {
    SMALL,
    MEDIUM,
    LARGE;

    @Override
    public String toString() {
        return this.name()
                .toLowerCase()
                .replace("_", " ");
    }
}
