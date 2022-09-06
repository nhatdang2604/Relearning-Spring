package com.example.service;

import com.example.entity.Tutor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class TutorService implements ITutorService {

    @Override
    public List<Tutor> getAll() {

        List<Tutor> tutors = new ArrayList<>();

        int size = 5;
        for (int i = 0; i < size; ++i) {
            tutors.add(new Tutor(i, "tutor_firstname_" + i, "tutor_lastname_" + i));
        }

        return tutors;
    }
}
