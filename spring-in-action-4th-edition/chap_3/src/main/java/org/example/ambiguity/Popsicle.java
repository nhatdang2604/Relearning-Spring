package org.example.ambiguity;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("cold")
public class Popsicle implements Dessert {

    @Override
    public void serve() {
        System.out.println("Serving popsicle");
    }
}
