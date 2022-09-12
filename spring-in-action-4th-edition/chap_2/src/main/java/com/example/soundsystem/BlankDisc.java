package com.example.soundsystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    @Override
    public void play() {
        System.out.println("Playing " + title +  " by " + artist);
        tracks.forEach(track -> {
           System.out.println("- Track: " + track);
        });
    }
}
