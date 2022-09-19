package org.example;

import org.example.concert.Encoreable;
import org.example.concert.Performance;
import org.example.soundsystem.BlankDisc;
import org.example.soundsystem.CompactDisc;
import org.example.soundsystem.XmlTrackCounter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("PerformanceConfig.xml");
        Performance performance = (Performance) ctx.getBean("metalPerformance");
        performance.perform();
        Encoreable encoreable = (Encoreable) performance;
        encoreable.performEncore();

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("SoundSystemConfig.xml");
//        CompactDisc cd = ctx.getBean(CompactDisc.class);
//        XmlTrackCounter counter = (XmlTrackCounter) ctx.getBean("xmlTrackCounter");
//        cd.playTrack(0);
//        cd.playTrack(0);
//        cd.playTrack(0);
//        System.out.println(counter.getPlayCount(0));
    }
}