package com.example.chap_7.spittr.data;

import com.example.chap_7.spittr.Spitter;

public interface SpitterRepository {
    public Spitter save(Spitter spitter);
    public Spitter findByUsername(String username);
}
