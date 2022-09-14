package org.example.config;

import org.example.soundsystem.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class ExpressiveConfig {

    @Autowired
    private Environment env;

    @Bean
    public BlankDisc blankDisc() {
        BlankDisc disc = new BlankDisc();
        disc.setTitle(env.getProperty("disc.title"));
        disc.setArtist(env.getProperty("disc.artist"));

        return disc;
    }
}
