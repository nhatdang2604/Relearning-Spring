package com.example.knight;

import com.example.quest.Quest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BraveKnight implements Knight {

    private Quest quest;
    private Minstrel minstrel;

    @Override
    public void embarkOnQuest() {
        minstrel.singBeforeQuest();
        quest.embark();
        minstrel.singAfterQuest();
    }
}
