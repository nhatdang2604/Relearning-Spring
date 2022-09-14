package org.example.config;

import org.example.soundsystem.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class ExpressiveConfig {

    @Autowired
    private Environment env;

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }

    @Bean
    public BlankDisc blankDisc(
            @Value("${disc.title}") String title,
            @Value("${disc.artist}") String artist) {
        BlankDisc disc = new BlankDisc(title, artist, null);

//        disc.setTitle(env.getProperty("disc.title", "Rattle and Hum"));
//        disc.setArtist(env.getProperty("disc.artist", "U2"));

        return disc;
    }
}
