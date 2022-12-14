package org.example.config;
import org.example.condition.MagicBean;
import org.example.condition.MagicExistsCondition;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan(basePackages="org.example")
@PropertySource("classpath:application.properties")
public class ConditionalConfig {

    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean() {
        return new MagicBean();
    }

}
