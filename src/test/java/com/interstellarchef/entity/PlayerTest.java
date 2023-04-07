package com.interstellarchef.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.interstellarchef.gui.GamePanel;
import com.interstellarchef.gui.KeyHandler;
import com.interstellarchef.object.Uniform;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void testSetItem() {
        GamePanel gp = new GamePanel();
        KeyHandler keyH = new KeyHandler(gp);
        Player player = new Player(gp, keyH);
        Entity item = new Uniform(gp);
        player.inventory.add(item);
        assertTrue(player.inventory.contains(item));
    }

}