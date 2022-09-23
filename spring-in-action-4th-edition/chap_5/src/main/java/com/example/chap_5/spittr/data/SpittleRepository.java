package com.example.chap_5.spittr.data;

import com.example.chap_5.spittr.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
