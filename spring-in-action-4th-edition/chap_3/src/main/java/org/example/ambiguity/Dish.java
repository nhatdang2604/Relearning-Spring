package org.example.ambiguity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@NoArgsConstructor
@Getter
public class Dish {

    private Dessert dessert;

    @Autowired
    @Qualifier("cold")
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }
}
