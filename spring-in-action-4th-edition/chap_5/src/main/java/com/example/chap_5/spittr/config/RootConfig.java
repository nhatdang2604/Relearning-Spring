package com.example.chap_5.spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(
        basePackages="com.example.chap_5.spittr",
        excludeFilters={    //ie exclude the WebConfig class
                @Filter(
                        type= FilterType.ANNOTATION,
                        value= EnableWebMvc.class)
        })
public class RootConfig {

}
