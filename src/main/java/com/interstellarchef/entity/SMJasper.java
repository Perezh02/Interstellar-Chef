package com.interstellarchef.entity;

import com.interstellarchef.Main;
import com.interstellarchef.gui.GamePanel;
import java.util.Random;

public class SMJasper extends Entity {

    public SMJasper(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
        setDialogue();
    }

    public void getImage() {
        up1 = setup("/npc/spaceman_white_up_1");
        up2 = setup("/npc/spaceman_white_up_2");
        down1 = setup("/npc/spaceman_white_down_1");
        down2 = setup("/npc/spaceman_white_down_2");
        left1 = setup("/npc/spaceman_white_left_1");
        left2 = setup("/npc/spaceman_white_left_2");
        right1 = setup("/npc/spaceman_white_right_1");
        right2 = setup("/npc/spaceman_white_right_2");
    }

    public void setDialogue() {
        // Get Dialogue from JSON
        String dialogue1 = Main.npcs[0].getName() + Main.npcs[0].getDialogue().get(0);
        String dialogue2 = Main.npcs[0].getName() + Main.npcs[0].getDialogue().get(1);
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
