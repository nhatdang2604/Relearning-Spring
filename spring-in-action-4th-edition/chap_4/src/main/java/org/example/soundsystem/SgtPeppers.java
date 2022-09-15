package org.example.soundsystem;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@Component("lonelyHeartsClub")
//@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";
    private List<String> tracks = new ArrayList<>();


    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

    @Override
    public void playTrack(int trackNumber) {
        System.out.println("- Track: " + tracks.get(trackNumber));
    }
}
