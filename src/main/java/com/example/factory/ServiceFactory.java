package com.example.factory;

import com.example.service.IStudentService;
import com.example.service.ITutorService;
import com.example.service.StudentService;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ServiceFactory {

    private static IStudentService studentService = StudentService.INSTANCE;
    private static ITutorService tutorService = TutorService.INSTANCE;
}
