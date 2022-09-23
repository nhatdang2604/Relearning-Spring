package com.example.chap_5.spittr.data;

import com.example.chap_5.spittr.Spittle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository {

    List<Spittle> spittles;

    public SpittleRepositoryImpl() {

        spittles = new ArrayList<>();
        mockData();
    }

    private void mockData() {
        int size = 100;
        for (long i = 0; i < size; ++i) {
            spittles.add(new Spittle(i, "test " + i, new Date(i), new Double(i), new Double(i)));
        }
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {

        List<Spittle> buffer = spittles
                .stream()
                .filter(spittle -> spittle.getId()<max)
                .limit(count)
                .collect(Collectors.toList());

        return buffer;
    }

    @Override
    public Spittle findOne(long id) {
        return spittles.stream()
                .filter(spittle -> spittle.getId().equals(id))
                .findAny()
                .orElse(null);
    }
}
