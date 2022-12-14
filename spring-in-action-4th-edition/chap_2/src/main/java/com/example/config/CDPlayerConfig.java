package com.example.config;

import com.example.soundsystem.CDPlayer;
import com.example.soundsystem.CompactDisc;
import com.example.soundsystem.MediaPlayer;
import com.example.soundsystem.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import(CDConfig.class)
//@ComponentScan(basePackages = {"com.example.soundsystem"})
//@ComponentScan(basePackages = "com.example.soundsystem")  //for implicit wiring
public class CDPlayerConfig {

//    @Bean(name="lonelyHeartsClubBand")
//    public CompactDisc sgtPeppers() {
//        return new SgtPeppers();
//    }

    //1st approach
//    @Bean
//    public MediaPlayer cdPlayer() {
//        return new CDPlayer(sgtPeppers());
//    }

    //2nd approach
    @Bean
    public MediaPlayer cdPlayer(CompactDisc compactDisc) {

        CDPlayer player = new CDPlayer();
        player.setCompactDisc(compactDisc);

        return player;
    }
}