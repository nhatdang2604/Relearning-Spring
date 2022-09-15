package org.example.config;

import org.example.concert.Audience;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AOPConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }
}
