package com.example.factory;

import com.example.service.IStudentService;
import com.example.service.ITutorService;
import com.example.service.StudentService;
import com.example.service.TutorService;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ServiceFactory {

    private static IStudentService studentService = StudentService.INSTANCE;
    private static ITutorService tutorService = new TutorService();

    public IStudentService createStudentService() {return studentService;}
    public ITutorService createTutorService() {return tutorService;}
}
