package com.example.soundsystem;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@NoArgsConstructor
//@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc compactDisc;

//    @Autowired
//    public CDPlayer(CompactDisc cd) {
//        this.cd = cd;
//    }

    @Autowired
    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    @Override
    public void play() {
        cd.play();
    }
}
