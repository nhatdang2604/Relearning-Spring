package org.example;

import org.example.concert.MetalPerformance;
import org.example.concert.Performance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        Performance performance = (Performance) ctx.getBean("metalPerformance");
        performance.perform();
    }
}