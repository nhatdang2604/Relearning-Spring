package org.example.ambiguity;

import org.springframework.stereotype.Component;

@Component
public class Cookies implements Dessert {

    @Override
    public void serve() {
        System.out.println("Serving cookies");
    }
}
