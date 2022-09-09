package com.example.chap_1;

import com.example.knight.Knight;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Chap1Application {

    public static void main(String[] args) {

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("knights.xml");

        Knight knight = ctx.getBean(Knight.class);
        knight.embarkOnQuest();
    }

}
