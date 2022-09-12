package com.example.soundsystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;

    @Override
    public void play() {
        System.out.println("Playing " + title +  " by " + artist);
    }
}
