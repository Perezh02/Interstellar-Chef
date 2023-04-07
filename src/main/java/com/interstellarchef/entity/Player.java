package com.interstellarchef.entity;

import com.interstellarchef.gui.GamePanel;
import com.interstellarchef.gui.KeyHandler;
import com.interstellarchef.object.Butter;
import com.interstellarchef.object.GPS;
import com.interstellarchef.object.Key;
import com.interstellarchef.object.Milk;
import com.interstellarchef.object.Noodles;
import com.interstellarchef.object.Tofu;
import com.interstellarchef.object.Tortillas;
import com.interstellarchef.object.Uniform;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Entity {

    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int maxInventorySize = 26;
    public int hasKey = 0;


    public Player(GamePanel gp, KeyHandler keyH) {

        super(gp);

        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
        setItems();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 37;
        worldY = gp.tileSize * 61;
        speed = 4;
        direction = "down";
        currentEquipped = new Uniform(gp);
    }

    public void setItems() {
        inventory.add(new Uniform(gp));
    }

    public void selectItem() {
        int itemIndex = gp.ui.getItemIndex();
        if (itemIndex < inventory.size()) {
            Entity selectedItem = inventory.get(itemIndex);
            if (selectedItem.type == typeSpacesuitEquipped
                || selectedItem.type == typeUniformEquipped) {
                currentEquipped = selectedItem;
                getPlayerImage();
            }
        }
    }

    public void getPlayerImage() {
        if (currentEquipped.type == typeUniformEquipped) {
            up1 = setup("/player/player_up_1", gp.tileSize, gp.tileSize);
            up2 = setup("/player/player_up_2", gp.tileSize, gp.tileSize);
            down1 = setup("/player/player_down_1", gp.tileSize, gp.tileSize);
            down2 = setup("/player/player_down_2", gp.tileSize, gp.tileSize);
            left1 = setup("/player/player_left_1", gp.tileSize, gp.tileSize);
            left2 = setup("/player/player_left_2", gp.tileSize, gp.tileSize);
            right1 = setup("/player/player_right_1", gp.tileSize, gp.tileSize);
            right2 = setup("/player/player_right_2", gp.tileSize, gp.tileSize);

        } else if (currentEquipped.type == typeSpacesuitEquipped) {
            up1 = setup("/player/spaceman_white_up_1", gp.tileSize, gp.tileSize);
            up2 = setup("/player/spaceman_white_up_2", gp.tileSize, gp.tileSize);
            down1 = setup("/player/spaceman_white_down_1", gp.tileSize, gp.tileSize);
            down2 = setup("/player/spaceman_white_down_2", gp.tileSize, gp.tileSize);
            left1 = setup("/player/spaceman_white_left_1", gp.tileSize, gp.tileSize);
            left2 = setup("/player/spaceman_white_left_2", gp.tileSize, gp.tileSize);
            right1 = setup("/player/spaceman_white_right_1", gp.tileSize, gp.tileSize);
            right2 = setup("/player/spaceman_white_right_2", gp.tileSize, gp.tileSize);
        }
    }

    public void update() {

        if (keyH.upPressed
            || keyH.downPressed || keyH.leftPressed || keyH.rightPressed || keyH.spacePressed) {
            if (keyH.upPressed) {
                direction = "up";
            } else if (keyH.downPressed) {
                direction = "down";
            } else if (keyH.leftPressed) {
                direction = "left";
            } else if (keyH.rightPressed) {
                direction = "right";
            }

            // CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // CHECK NPC COLLISION
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            // CHECK EVENT
            gp.eHandler.checkEvent();

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if (!collisionOn && !keyH.spacePressed) {

                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            gp.keyH.spacePressed = false;

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void pickUpObject(int i) {

        if (i != 999) {
            String objectName = gp.obj[i].name;
            if (objectName.equals("Door")) {
                if (hasKey > 0) {
                    gp.obj[i] = null;
                }
            } else {
                inventory.add(gp.obj[i]);
                gp.obj[i] = null;
            }
        }
    }

    public void interactNPC(int i) {

        if (gp.keyH.spacePressed) {
            if (i != 999) {
                if (gp.npc[i] instanceof Cadet) {
                    Tortillas tortilla = ((Cadet) gp.npc[i]).giveItem();
                    if (tortilla != null) {
                        inventory.add(tortilla);
                        gp.npc[i].dialogueIndex = 0;
                    } else {
                        gp.npc[i].dialogueIndex = 1;
                    }
                }
                else if (gp.npc[i] instanceof Gardener) {
                    Milk milk = ((Gardener) gp.npc[i]).giveItem();
                    if (milk != null) {
                        inventory.add(milk);
                        gp.npc[i].dialogueIndex = 0;
                    } else {
                        gp.npc[i].dialogueIndex = 1;
                    }
                }
                else if (gp.npc[i] instanceof Fanatic) {
                    Butter butter = ((Fanatic) gp.npc[i]).giveItem();
                    if (butter != null) {
                        inventory.add(butter);
                        gp.npc[i].dialogueIndex = 0;
                    } else {
                        gp.npc[i].dialogueIndex = 1;
                    }
                }
                else if (gp.npc[i] instanceof Liaison) {
                    GPS gps = ((Liaison) gp.npc[i]).giveItem();
                    if (gps != null) {
                        inventory.add(gps);
                        gp.npc[i].dialogueIndex = 0;
                    } else {
                        gp.npc[i].dialogueIndex = 1;
                    }
                }
                else if (gp.npc[i] instanceof Technician) {
                    Tofu tofu = ((Technician) gp.npc[i]).giveItem();
                    if (tofu != null) {
                        inventory.add(tofu);
                        gp.npc[i].dialogueIndex = 0;
                    } else {
                        gp.npc[i].dialogueIndex = 1;
                    }
                }
                else if (gp.npc[i] instanceof Pod) {
                    Key key = ((Pod) gp.npc[i]).giveItem();
                    if (key != null) {
                        inventory.add(key);
                        hasKey++;
                        gp.npc[i].dialogueIndex = 0;
                    } else {
                        gp.npc[i].dialogueIndex = 1;
                    }
                }
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, null);

    }
}

