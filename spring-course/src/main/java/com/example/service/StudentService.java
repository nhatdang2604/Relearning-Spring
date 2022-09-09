package com.example.service;

import com.example.entity.Student;

import java.util.ArrayList;
import java.util.List;

public enum StudentService implements IStudentService {

    INSTANCE;

    private StudentService() {
        //do nothing
    }

    @Override
    public List<Student> getAll() {

        List<Student> students = new ArrayList<>();

        int size = 10;
        for (int i = 0; i < size; ++i) {
            students.add(new Student(i, "firstname_test_" + i, "lastname_test_"+ i));
        }

        return students;
    }
}
