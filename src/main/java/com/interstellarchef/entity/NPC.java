package com.interstellarchef.entity;

import java.util.List;

public class NPC {

    public String name;
    public List<String> dialogue;
    public List<String> riddles;

    public NPC(String name, List<String> dialogue, List<String> riddles) {
        this.name = name;
        this.dialogue = dialogue;
        this.riddles = riddles;
    }

    public String getName() {
        return name;
    }

    public List<String> getDialogue() {
        return dialogue;
    }

    public List<String> getRiddle() {
        return riddles;
    }
}
