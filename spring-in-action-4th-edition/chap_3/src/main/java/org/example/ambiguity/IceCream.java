package org.example.ambiguity;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class IceCream implements Dessert {

    @Override
    public void serve() {
        System.out.println("Serving ice cream");
    }
}
