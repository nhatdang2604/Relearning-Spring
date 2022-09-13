package org.example.config;
import org.example.MagicBean;
import org.example.condition.MagicExistsCondition;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan(basePackages="org.example")
@PropertySource("classpath:application.properties")
public class BeanConfig {

    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean() {
        return new MagicBean();
    }

}
