package com.example.chap_5.spittr.data;

import com.example.chap_5.spittr.Spitter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {

    private static Long nNEXT_AVAILABLE_ID = 0L;
    private Map<Long, Spitter> spitters;

    private static Long getNextAvailableId() {
        return ++nNEXT_AVAILABLE_ID;
    }

    public SpitterRepositoryImpl() {
        spitters = new HashMap<>();
    }

    @Override
    public void save(Spitter spitter) {
        Long id = getNextAvailableId();
        spitter.setId(id);
        spitters.put(id, spitter);
    }
}
