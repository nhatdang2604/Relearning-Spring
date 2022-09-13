package org.example;

import org.example.config.ConditionalConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(ConditionalConfig.class);
        System.out.println(ctx.containsBean("magicBean"));
    }
}