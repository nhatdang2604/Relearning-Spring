package org.example.config;
import org.example.MagicBean;
import org.example.condition.MagicExistsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(MagicExistsCondition.class)
public class BeanConfig {

    @Bean
    public MagicBean magicBean() {
        return new MagicBean();
    }

}
