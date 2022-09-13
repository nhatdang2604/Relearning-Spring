package org.example.config;

import org.example.ambiguity.Dish;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmbiguityConfig {

    @Bean
    public Dish dish() {
        return new Dish();
    }
}
