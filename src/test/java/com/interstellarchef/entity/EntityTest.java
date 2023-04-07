package com.interstellarchef.entity;

import static org.junit.jupiter.api.Assertions.*;

import com.interstellarchef.gui.GamePanel;
import org.junit.jupiter.api.Test;

public class EntityTest {

    @Test
    public void testSpeak() {
        GamePanel gp = new GamePanel();
        Entity entity = new Entity(gp);
        entity.dialogues[0] = "Hello";
        entity.dialogues[1] = "How are you?";

        entity.speak();
        assertEquals("Hello", gp.ui.currentDialogue);

        entity.speak();
        assertEquals("How are you?", gp.ui.currentDialogue);

        entity.speak();
        assertEquals("Hello", gp.ui.currentDialogue);
    }
}