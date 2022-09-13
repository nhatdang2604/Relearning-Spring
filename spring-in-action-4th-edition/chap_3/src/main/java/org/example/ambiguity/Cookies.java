package org.example.ambiguity;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("crispy")
public class Cookies implements Dessert {

    @Override
    public void serve() {
        System.out.println("Serving cookies");
    }
}
