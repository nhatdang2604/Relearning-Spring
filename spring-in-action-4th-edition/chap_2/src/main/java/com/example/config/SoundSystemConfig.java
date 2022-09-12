package com.example.config;

import com.example.soundsystem.CompactDisc;
import com.example.soundsystem.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({CDPlayerConfig.class})
@ImportResource("classpath:CDConfig.xml")
public class SoundSystemConfig {

}