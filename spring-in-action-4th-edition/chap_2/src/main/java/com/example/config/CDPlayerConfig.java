package com.example.config;

import com.example.soundsystem.CompactDisc;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = {"com.example.soundsystem"})
@ComponentScan(basePackageClasses = CompactDisc.class)
public class CDPlayerConfig {

}
