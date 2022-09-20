package com.example.chap_5.spittr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@PropertySource(value="classpath:application.properties")
@ComponentScan(basePackages="com.example.chap_5.spittr.web")
public class WebConfig {

    @Autowired
    private Environment env;

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();

        String prefix = env.getProperty("view.prefix");
        String suffix = env.getProperty("view.suffix");

        resolver.setPrefix(prefix);
        resolver.setSuffix(suffix);

        //making bind the bean as ${} in jsp
        resolver.setExposeContextBeansAsAttributes(true);

        return resolver;
    }
}
