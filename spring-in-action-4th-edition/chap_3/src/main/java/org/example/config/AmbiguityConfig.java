package org.example.config;

import org.example.ambiguity.Dish;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="org.example.ambiguity")
public class AmbiguityConfig {

    @Bean
    public Dish dish() {
        return new Dish();
    }
}
