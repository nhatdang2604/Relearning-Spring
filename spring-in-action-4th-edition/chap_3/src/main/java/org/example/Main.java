package org.example;

import org.example.config.BeanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
        System.out.println(ctx.containsBean("magicBean"));
    }
}