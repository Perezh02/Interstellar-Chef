package com.interstellarchef.gui;

import com.interstellarchef.entity.DesertMON;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.entity.NPC;
import com.interstellarchef.tile.TileManager;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    NPC npc;
    Font arial_40, arial_80B;
    public boolean messageOn = false;
    public String message = "";
    public String currentDialogue = "";
    public String currentRiddle = "";
    public int commandNum = 0;
    public int slotCol = 0;
    public int slotRow = 0;
    public int titleScreenState = 0;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

        // PLAY STATE
        if (gp.gameState == gp.playState) {
            int currentLocationNum = gp.tileM.locationMap[gp.player.worldX / gp.tileSize][gp.player.worldY / gp.tileSize];
            String locationName = gp.tileM.getLocationName(currentLocationNum);
            g2.drawString(locationName, 50, 50);
        }
        // TITLE STATE
        if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }
        // PAUSE STATE
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }
        // DIALOGUE STATE
        if (gp.gameState == gp.dialogueState) {
            drawDialogueScreen();
        }
        // INVENTORY STATE
        if (gp.gameState == gp.inventoryState) {
            drawInventoryScreen();
            drawInventory();
        }
        // RIDDLE STATE
        if (gp.gameState == gp.riddleState) {
            drawRiddleScreen();
        }
    }

    public void drawTitleScreen() {

            g2.setColor(new Color(0, 0, 0));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
            // TITLE NAME
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
            String text = "INTERSTELLAR CHEF";
            int x = getXforCenteredText(text);
            int y = gp.tileSize * 3;

            // SHADOW
            g2.setColor(Color.GRAY);
            g2.drawString(text, x + 5, y + 5);

            // MAIN COLOR
            g2.setColor(Color.WHITE);
            g2.drawString(text, x, y);

            // PLAYER IMAGE
            x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
            y += gp.tileSize * 2;
            g2.drawImage(gp.player.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);

            // MENU
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));

            text = "NEW GAME";
            x = getXforCenteredText(text);
            y += gp.tileSize * 3.5;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "QUIT";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x - gp.tileSize, y);
            }
    }



    public void drawRiddleScreen() {
        g2.setColor(new Color(0, 0, 0));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        // TITLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20));
        String text = "YOU MUST SOLVE THIS RIDDLE TO PASS ME!!";
        int x = getXforCenteredText(text);
        int y = gp.tileSize * 2;
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);

        //Menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 15));

        String[] riddlesHC = new String[20];


//        riddlesHC.add("I am a spotted cat and I do not roar. \nI live on the forest floor and in the understory. \nWhat am I? (1)Jaguar (2)Puddle (3)Cow (4)Eagle");
//        riddlesHC.add("What is a name for a natural satellite? \n (1)Moon (2)Sun (3)Earth (4)Verizon");
//        riddlesHC.add("I can have 1 or 2 humps, a very long neck, \nand am known for taking long treks across the desert. \nWhat am I? (1)Camel (2)Zebra (3)Horse (4)Python");

        String riddlesQuestion1 = "I am hot and molten, and reside underneath the Earth's crust. \n";
        String RiddleAnswer1 = "What am I?  (1)Magma (2)Worm (3)Mantle (4)Groundhog";
//        String riddles2 = " I am a spotted cat and I do not roar. \nI live on the forest floor and in the understory. \nWhat am I? (1)Jaguar (2)Puddle (3)Cow (4)Eagle";
//        String riddles3 = " What is a name for a natural satellite? \n (1)Moon (2)Sun (3)Earth (4)Verizon";
//        String riddles4 = " I can have 1 or 2 humps, a very long neck, \nand am known for taking long treks across the desert. \nWhat am I? (1)Camel (2)Zebra (3)Horse (4)Python";



        text = riddlesQuestion1;
        x = getXforCenteredText(text);
        y += gp.tileSize * 2.2;
        g2.drawString(text, x, y);

        text = RiddleAnswer1;
        x = getXforCenteredText(text);
        y += gp.tileSize * 1;
        g2.drawString(text, x, y);

        text = "Choice-1";
        x = getXforCenteredText(text);
        y += gp.tileSize * 3;
        g2.drawString(text, x, y);
        if (commandNum == 0) {
            g2.drawString(">", x - gp.tileSize, y);
        }

        text = "Choice-2";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if (commandNum == 1) {
            g2.drawString(">", x - gp.tileSize, y);
        }

        text = "Choice-3";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if (commandNum == 2) {
            g2.drawString(">", x - gp.tileSize, y);
        }

        text = "Choice-4";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if (commandNum == 3) {
            g2.drawString(">", x - gp.tileSize, y);
        }


    }



    public void drawDialogueScreen() {
        // WINDOW
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;

        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 28F));
        x += gp.tileSize;
        y += gp.tileSize;

        for (String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }

    }

    public void drawSubWindow(int x, int y, int width, int height) {

        Color c = new Color(0, 0, 0, 200);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);

    }

    public void drawInventoryScreen() {
        final int frameX = gp.tileSize;
        final int frameY = gp.tileSize * 7 + 20;
        final int frameWidth = gp.tileSize * 5;
        final int frameHeight = gp.tileSize * 3 / 2;

        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        g2.setColor(Color.WHITE);
        g2.setFont(g2.getFont().deriveFont(32F));

        int textX = frameX + 20;
        int textY = frameY + gp.tileSize;

        g2.drawString("Equipped: ", textX, textY);

        g2.drawImage(gp.player.currentEquipped.down1, textX + 150, textY - 35, null);

    }

    public void drawInventory() {
        int frameX = gp.tileSize;
        int frameY = gp.tileSize * 9;
        int frameWidth = gp.tileSize * 14;
        int frameHeight = gp.tileSize * 3;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 10;
        int slotX = slotXstart;
        int slotY = slotYstart;

        for (int i = 0; i < gp.player.inventory.size(); i++) {

            if (gp.player.inventory.get(i) == gp.player.currentEquipped) {
                g2.setColor(new Color(240, 190, 90));
                g2.fillRoundRect(slotX, slotY, gp.tileSize, gp.tileSize, 10, 10);
            }
            g2.drawImage(gp.player.inventory.get(i).down1, slotX, slotY, null);
            slotX += gp.tileSize;

            if (i == 12 || i == 25) {
                slotX = slotXstart;
                slotY += gp.tileSize;
            }
        }
        int cursorX = slotXstart + (gp.tileSize * slotCol);
        int cursorY = slotYstart + (gp.tileSize * slotRow);
        int cursorWidth = gp.tileSize;
        int cursorHeight = gp.tileSize;
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);

        // ITEM DESCRIPTION
        int dFrameX = frameX * 6 + 4;
        int dFrameY = frameY - frameHeight - 4;
        int dFrameWidth = frameWidth - gp.tileSize * 5;
        int dFrameHeight = gp.tileSize * 3;


        int textX = dFrameX + 20;
        int textY = dFrameY + gp.tileSize;
        g2.setFont(g2.getFont().deriveFont(28F));

        int itemIndex = getItemIndex();

        if (itemIndex < gp.player.inventory.size()) {
            drawSubWindow(dFrameX, dFrameY, dFrameWidth, dFrameHeight);
            for (String line : gp.player.inventory.get(itemIndex).description.split("\n")) {
                g2.drawString(line, textX, textY);
                textY += 32;
            }
        }

    }

    public void drawPauseScreen() {

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }

    public int getItemIndex() {
        int itemIndex = slotCol + (slotRow * 13);
        return itemIndex;
    }

    public int getXforCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}