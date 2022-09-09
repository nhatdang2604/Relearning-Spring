package com.example.knight;

import lombok.AllArgsConstructor;

import java.io.PrintStream;

@AllArgsConstructor
public class Minstrel {

    private PrintStream stream;

    public void singBeforeQuest() {
        stream.println("Fa la la, the knight is so brave!");
    }

    public void singAfterQuest() {
        stream.println("Tee hee hee, the brave knight did embark on a quest");
    }
}
