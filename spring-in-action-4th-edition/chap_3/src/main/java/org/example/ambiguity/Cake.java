package org.example.ambiguity;

import org.springframework.stereotype.Component;

@Component
public class Cake implements Dessert {

    @Override
    public void serve() {
        System.out.println("Serving cake");
    }
}
