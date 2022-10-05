package com.example.chap_7.spittr.data;

import com.example.chap_7.spittr.Spitter;

import javax.servlet.http.Part;

public interface SpitterRepository {
    public Spitter save(Spitter spitter);
    public int saveFile(Part part);
    public Spitter findByUsername(String username);
}
