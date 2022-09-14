package org.example;

import org.example.config.ConditionalConfig;
import org.example.config.ExpressiveConfig;
import org.example.soundsystem.BlankDisc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(ExpressiveConfig.class);
        BlankDisc disc = ctx.getBean(BlankDisc.class);
        disc.play();
    }
}