package com.interstellarchef.entity;

import java.util.List;

public class NPC {

    public String name;
    public List<String> dialogue;

    public NPC(String name, List<String> dialogue) {
        this.name = name;
        this.dialogue = dialogue;
    }

    public String getName() {
        return name;
    }

    public List<String> getDialogue() {
        return dialogue;
    }
}
