package com.example.chap_7.spittr.data;

import com.example.chap_7.spittr.Spittle;

import java.util.List;

public interface SpittleRepository {
    public List<Spittle> findSpittles(long max, int count);
    public Spittle findOne(long id);

}
