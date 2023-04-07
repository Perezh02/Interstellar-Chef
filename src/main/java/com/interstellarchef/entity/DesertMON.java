package com.interstellarchef.entity;

import com.interstellarchef.Main;
import com.interstellarchef.gui.GamePanel;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class DesertMON extends Entity {
    public String riddle;

    public DesertMON(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;
        riddle = Main.npcs[18].getRiddle().get(0);

        getImage();
        setDialogue();
//        setRiddle();
    }

    public void getImage() {
        up1 = setup("/npc/desert_up_1", gp.tileSize, gp.tileSize);
        up2 = setup("/npc/desert_up_2", gp.tileSize, gp.tileSize);
        down1 = setup("/npc/desert_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/desert_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("/npc/desert_left_1", gp.tileSize, gp.tileSize);
        left2 = setup("/npc/desert_left_2", gp.tileSize, gp.tileSize);
        right1 = setup("/npc/desert_right_1", gp.tileSize, gp.tileSize);
        right2 = setup("/npc/desert_right_2", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {
        // Get Dialogue from JSON
        String dialogue1 = Main.npcs[18].getName() + Main.npcs[18].getDialogue().get(0);
        String dialogue2 = Main.npcs[18].getName() + Main.npcs[18].getDialogue().get(1);
        dialogues[0] = dialogue1;
        dialogues[1] = dialogue2;
    }

    public void setRiddle() {
        // Get Dialogue from JSON
        String riddle1 = Main.npcs[18].getName() + Main.npcs[18].getRiddle().get(0);
        riddles[0] = riddle1;


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




//
//    public void drawTitleScreen() {
//
//
//        g2.setColor(new Color(0, 0, 0));
//        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
//        // TITLE NAME
//        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
//        String text = "INTERSTELLAR CHEF";
//        int x = getXforCenteredText(text);
//        int y = gp.tileSize * 3;
//
//        // SHADOW
//        g2.setColor(Color.GRAY);
//        g2.drawString(text, x + 5, y + 5);
//
//        // MAIN COLOR
//        g2.setColor(Color.WHITE);
//        g2.drawString(text, x, y);
//
//        // PLAYER IMAGE
//        x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
//        y += gp.tileSize * 2;
//        g2.drawImage(gp.player.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);
//
//        // MENU
//        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
//
//        text = "NEW GAME";
//        x = getXforCenteredText(text);
//        y += gp.tileSize * 3.5;
//        g2.drawString(text, x, y);
//        if (commandNum == 0) {
//            g2.drawString(">", x - gp.tileSize, y);
//        }
//
//        text = "QUIT";
//        x = getXforCenteredText(text);
//        y += gp.tileSize;
//        g2.drawString(text, x, y);
//        if (commandNum == 1) {
//            g2.drawString(">", x - gp.tileSize, y);
//        }
//    }
//
//    public void drawDialogueScreen() {
//        // WINDOW
//        int x = gp.tileSize * 2;
//        int y = gp.tileSize / 2;
//        int width = gp.screenWidth - (gp.tileSize * 4);
//        int height = gp.tileSize * 4;
//
//        drawSubWindow(x, y, width, height);
//
//        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 28F));
//        x += gp.tileSize;
//        y += gp.tileSize;
//
//        for (String line : currentDialogue.split("\n")) {
//            g2.drawString(line, x, y);
//            y += 40;
//        }
//    }

    public void speak() {

        super.speak();
    }

}
