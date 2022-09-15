package org.example.soundsystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Playing " + title +  " by " + artist);

        if (null == tracks) {
            return;
        }

        tracks.forEach(track -> {
           System.out.println("- Track: " + track);
        });
    }

    @Override
    public void playTrack(int trackNumber) {
        if (trackNumber < 0 || trackNumber >= tracks.size()) {
            return;
        }
        System.out.println("- Track: " + tracks.get(trackNumber));
    }
}
