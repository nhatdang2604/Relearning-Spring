package com.example.chap_9.spittr.config;

import com.example.chap_9.spittr.data.SpitterRepository;
import com.example.chap_9.spittr.security.SpitterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
@EnableWebMvcSecurity
@PropertySource(value={
        "classpath:application.properties",
})public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                    .anyRequest().authenticated()
//                    .and()
//                .formLogin().and()
//                .httpBasic();
//
//    }

    //In-mem authentication
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder().encode("password")).roles("USER").and()
//                .withUser("admin").password(passwordEncoder().encode("password")).roles("USER", "ADMIN");
//
//    }

    @Autowired
    private SpitterRepository spitterRepository;

    @Value("${path.spittles}")
    private String spittlesPath;

    //Custom authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(
                new SpitterUserService(spitterRepository, passwordEncoder())
        );

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/spitters/me").authenticated()
                .antMatchers(HttpMethod.POST, spittlesPath).authenticated()
                .anyRequest().permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
