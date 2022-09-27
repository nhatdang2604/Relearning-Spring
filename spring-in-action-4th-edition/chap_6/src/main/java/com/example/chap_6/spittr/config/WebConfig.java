package com.example.chap_6.spittr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.validation.Validator;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={
        "com.example.chap_6.spittr.web",
        "com.example.chap_6.spittr.data"})
@PropertySource(value={
        "classpath:application.properties",
//        "classpath:ValidationMessages.properties"
})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;

//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new
//                ReloadableResourceBundleMessageSource();
//
//        messageSource.setBasename("classpath:ValidationMessages.properties");
//        return messageSource;
//    }
//
//    @Bean
//    public Validator validator() {
//        LocalValidatorFactoryBean bean =
//                new LocalValidatorFactoryBean();
//
//        bean.setValidationMessageSource(messageSource());
//        return bean;
//    }

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

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {

        configurer.enable();
    }
}
