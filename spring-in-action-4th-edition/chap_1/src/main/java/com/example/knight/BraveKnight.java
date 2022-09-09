package com.example.knight;

import com.example.quest.Quest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BraveKnight implements Knight {

    private Quest quest;

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
