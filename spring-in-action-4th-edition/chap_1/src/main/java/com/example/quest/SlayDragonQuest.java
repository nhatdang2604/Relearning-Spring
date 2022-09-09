package com.example.quest;

import lombok.AllArgsConstructor;

import java.io.PrintStream;

@AllArgsConstructor
public class SlayDragonQuest implements Quest {

    private PrintStream stream;

    @Override
    public void embark() {
        stream.println("Embarking on quest to slay the dragon!");
    }
}
