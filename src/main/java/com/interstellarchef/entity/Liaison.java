package com.interstellarchef.entity;

import com.interstellarchef.Main;
import com.interstellarchef.gui.GamePanel;
import java.util.Random;

public class Liaison extends Entity {

    public Liaison(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
        setDialogue();
    }

    public void getImage() {
        up1 = setup("/npc/liaison_up_1", gp.tileSize, gp.tileSize);
        up2 = setup("/npc/liaison_up_2", gp.tileSize, gp.tileSize);
        down1 = setup("/npc/liaison_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/liaison_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("/npc/liaison_left_1", gp.tileSize, gp.tileSize);
        left2 = setup("/npc/liaison_left_2", gp.tileSize, gp.tileSize);
        right1 = setup("/npc/liaison_right_1", gp.tileSize, gp.tileSize);
        right2 = setup("/npc/liaison_right_2", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {
        // Get Dialogue from JSON
        String dialogue1 = Main.npcs[8].getName() + Main.npcs[8].getDialogue().get(0);
        String dialogue2 = Main.npcs[8].getName() + Main.npcs[8].getDialogue().get(1);
        dialogues[0] = dialogue1;
        dialogues[1] = dialogue2;
    }

    public void setAction() {

        actionLockCounter++;

        if (actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1; // pick up a number from 1 to 100

            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75) {
                direction = "right";
            }

            actionLockCounter = 0;
        }
    }

    public void speak() {

        super.speak();
    }

}