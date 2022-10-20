package com.example.chap_9.spittr.data;

import com.example.chap_9.spittr.Spitter;
import com.example.chap_9.spittr.config.SpittrWebInitializer;
import org.springframework.stereotype.Repository;

import javax.servlet.http.Part;
import java.io.File;
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
    public Spitter save(Spitter spitter) {
        Long id = getNextAvailableId();
        spitter.setId(id);
        spitters.put(id, spitter);

        return spitter;
    }

    @Override
    public int saveFile(Part part) {

        String filename = part.getSubmittedFileName();
        String path = SpittrWebInitializer.TEMP_DIR_LOCATION;
        String filepath = path + "/" + filename;
        File file = new File(filepath);

        //Create file if it's not exsited
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception exception) {
                exception.printStackTrace();
                return 1;
            }
        }

        try {
            part.write(filepath);
        } catch (Exception exception) {
            exception.printStackTrace();
            return 2;
        }

        return 0;
    }

    @Override
    public Spitter findByUsername(String username) {

        //Filtering by username + get the first entry
        Map.Entry<Long, Spitter> e = spitters
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().getUsername().equals(username))
                .findFirst()
                .orElse(null);

        //Return the spitter, if the entry which have the spitter having the same username existed,
        //  or else, return null
        return (null != e?e.getValue():null);
    }
}
