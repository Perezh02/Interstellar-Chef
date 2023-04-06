package com.interstellarchef.gui;

public class EventHandler {

    GamePanel gp;
    EventRect eventRect[][];

    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    public boolean isInPlanet;

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];

        int col = 0;
        int row = 0;
        while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
            eventRect[col][row] = new EventRect();
            eventRect[col][row].x = 23;
            eventRect[col][row].y = 23;
            eventRect[col][row].width = 2;
            eventRect[col][row].height = 2;
            eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;

            col++;
            if (col == gp.maxWorldCol) {
                col = 0;
                row++;
            }
        }


    }

    public void checkEvent() {
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if (distance > gp.tileSize) {
            canTouchEvent = true;
        }

        if (canTouchEvent) {
            // FOREST PLANET
            if (hit(46, 12, "any")) {
                teleport(18, 12, gp.dialogueState);
            }
            if (hit(18, 11, "any")) {
                teleport(50, 14, gp.dialogueState);
            }
            // SNOW PLANET
            if (hit(54, 12, "any")) {
                teleport(91, 22, gp.dialogueState);
            }
            if (hit(92, 22, "any")) {
                teleport(50, 14, gp.dialogueState);
            }
            // LAVA PLANET
            if (hit(46, 16, "any")) {
                teleport(17, 92, gp.dialogueState);
            }
            if (hit(18, 92, "any")) {
                teleport(50, 14, gp.dialogueState);
            }
            // DESERT PLANET
            if (hit(54, 16, "any")) {
                teleport(81, 93, gp.dialogueState);
            }
            if (hit(80, 93, "any")) {
                teleport(50, 14, gp.dialogueState);
            }
        }

    }

    public boolean hit(int col, int row, String reqDirection) {
        boolean hit = false;

        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect[col][row].x = col * gp.tileSize + eventRect[col][row].x;
        eventRect[col][row].y = row * gp.tileSize + eventRect[col][row].y;

        if (gp.player.solidArea.intersects(eventRect[col][row]) && !eventRect[col][row].eventDone) {
            if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                hit = true;

                previousEventX = gp.player.worldX;
                previousEventY = gp.player.worldY;
            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
        eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;

        return hit;
    }

    public void teleport(int col, int row, int gameState) {

        // FOREST PLANET
        if (hit(46, 12, "any")) {
            gp.gameState = gameState;
            gp.ui.currentDialogue = "Welcome to the Forest Planet!";
            gp.player.worldX = gp.tileSize * 18;
            gp.player.worldY = gp.tileSize * 12;
            isInPlanet = true;
            musicHandler(1);

        }
        else if (hit(18, 11, "any")) {
            gp.gameState = gameState;
            gp.ui.currentDialogue = "Welcome home, chef!";
            gp.player.worldX = gp.tileSize * 50;
            gp.player.worldY = gp.tileSize * 14;
            isInPlanet = false;
            musicHandler(0);
        }
        // SNOW PLANET
        else if (hit(54, 12, "any")) {
            gp.gameState = gameState;
            gp.ui.currentDialogue = "Welcome to the Snow Planet!";
            gp.player.worldX = gp.tileSize * 91;
            gp.player.worldY = gp.tileSize * 22;
            isInPlanet = true;
            musicHandler(1);
        }
        else if (hit(92, 22, "any")) {
            gp.gameState = gameState;
            gp.ui.currentDialogue = "Welcome home, chef!";
            gp.player.worldX = gp.tileSize * 50;
            gp.player.worldY = gp.tileSize * 14;
            isInPlanet = false;
            musicHandler(0);
        }
        // LAVA PLANET
        else if (hit(46, 16, "any")) {
            gp.gameState = gameState;
            gp.ui.currentDialogue = "Welcome to the Lava Planet!";
            gp.player.worldX = gp.tileSize * 17;
            gp.player.worldY = gp.tileSize * 92;
            isInPlanet = true;
            musicHandler(1);
        }
        else if (hit(18, 92, "any")) {
            gp.gameState = gameState;
            gp.ui.currentDialogue = "Welcome home, chef!";
            gp.player.worldX = gp.tileSize * 50;
            gp.player.worldY = gp.tileSize * 14;
            isInPlanet = false;
            musicHandler(0);
        }
        // DESERT PLANET
        else if (hit(54, 16, "any")) {
            gp.gameState = gameState;
            gp.ui.currentDialogue = "Welcome to the Desert Planet!";
            gp.player.worldX = gp.tileSize * 81;
            gp.player.worldY = gp.tileSize * 93;
            isInPlanet = true;
            musicHandler(1);
        }
        else if (hit(80, 93, "any")) {
            gp.gameState = gameState;
            gp.ui.currentDialogue = "Welcome home, chef!";
            gp.player.worldX = gp.tileSize * 50;
            gp.player.worldY = gp.tileSize * 14;
            isInPlanet = false;
            musicHandler(0);
        }
    }

    public void musicHandler(int musicIndex) {
        if (gp.isMusicPlaying()) {
            gp.stopMusic();
            gp.playMusic(musicIndex);
        }
    }

    public boolean isInPlanet() {
        return isInPlanet;
    }



}
