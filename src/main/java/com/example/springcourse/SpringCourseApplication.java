package com.example.springcourse;

import com.example.config.AppConfig;
import com.example.service.IStudentService;
import com.example.service.ITutorService;
import com.example.service.StudentService;
import com.example.service.TutorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class SpringCourseApplication {

    public static void main(String[] args) {
        //1st approach: Java code
//        ApplicationContext ctx
//                = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        IStudentService studentService = ctx.getBean(IStudentService.class);
//        System.out.println(studentService.getAll());

        //2nd approach
//        AnnotationConfigApplicationContext ctx
//                = new AnnotationConfigApplicationContext();
//
//        ctx.register(AppConfig.class);
//        ctx.refresh();
//
//        IStudentService studentService = ctx.getBean(IStudentService.class);
//        System.out.println(studentService.getAll());

        //3rd approach: xml config
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("services.xml");

        IStudentService studentService = ctx.getBean(StudentService.class);
        System.out.println(studentService.getAll());
        ITutorService tutorService = ctx.getBean(TutorService.class);
        System.out.println(tutorService.getAll());
    }
}
