package com.example.springcourse;

import com.example.config.AppConfig;
import com.example.service.IStudentService;
import com.example.service.ITutorService;
import com.example.service.StudentService;
import com.example.service.TutorService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

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

        //Usage of factory
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("services.xml"));
        System.out.println(factory.getType("studentService"));

        //Test to prove that the the Bean is signleton
        System.out.println(ctx.getBean(TutorService.class) == ctx.getBean("tutorService"));
    }
}
