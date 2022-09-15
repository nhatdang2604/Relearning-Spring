package org.example.config;

import org.example.concert.Audience;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages="org.example")
public class AOPConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }
}
