package com.example.chap_5.spittr.data;

import com.example.chap_5.spittr.Spitter;

public interface SpitterRepository {
    public void save(Spitter spitter);
    public Spitter findByUsername(String username);
}
