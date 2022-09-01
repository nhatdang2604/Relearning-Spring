package com.example.springcourse;

import com.example.config.AppConfig;
import com.example.service.IStudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class SpringCourseApplication {

    public static void main(String[] args) {
        ApplicationContext ctx
                = new AnnotationConfigApplicationContext(AppConfig.class);

        IStudentService studentService = ctx.getBean(IStudentService.class);
        System.out.println(studentService.getAll());
    }

}
