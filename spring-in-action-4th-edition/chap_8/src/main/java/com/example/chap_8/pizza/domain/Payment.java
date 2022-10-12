package com.example.chap_8.pizza.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    private float amount;
}
