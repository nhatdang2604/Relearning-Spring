package com.example.config;

import com.example.service.IStudentService;
import com.example.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public IStudentService studentService() {
        return StudentService.INSTANCE;
    }
}
