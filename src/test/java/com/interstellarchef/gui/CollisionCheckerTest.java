//package com.interstellarchef.gui;
//
//import com.interstellarchef.entity.Entity;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class CollisionCheckerTest {
//
//    private GamePanel gamePanel;
//    private CollisionChecker collisionChecker;
//
//    @BeforeEach
//    public void setup() {
//        gamePanel = new GamePanel();
//        collisionChecker = new CollisionChecker(gamePanel);
//    }
//
//    @Test
//    public void testCheckTile_noCollision() {
//        Entity entity = new Entity(gamePanel);
//        entity.worldX = 50;
//        entity.worldY = 50;
//        entity.direction = "down";
//        entity.solidArea.x = 0;
//        entity.solidArea.y = 0;
//        entity.solidArea.width = 32;
//        entity.solidArea.height = 32;
//        entity.speed = 5;
//
//        collisionChecker.checkTile(entity);
//
//        assertFalse(entity.collisionOn);
//    }
//
//    @Test
//    public void testCheckObject_collision() {
//        Entity entity = new Entity(gamePanel);
//        entity.worldX = 50;
//        entity.worldY = 50;
//        entity.direction = "down";
//        entity.solidArea.x = 0;
//        entity.solidArea.y = 0;
//        entity.solidArea.width = 32;
//        entity.solidArea.height = 32;
//        entity.speed = 5;
//
//        GameObject gameObject = new GameObject(gamePanel, "test", 50, 50, true);
//        gamePanel.obj[0] = gameObject;
//
//        collisionChecker.checkObject(entity, false);
//
//        assertTrue(entity.collisionOn);
//    }
//
//    @Test
//    public void testCheckEntity_noCollision() {
//        Entity entity = new Entity(gamePanel);
//        entity.worldX = 50;
//        entity.worldY = 50;
//        entity.direction = "down";
//        entity.solidArea.x = 0;
//        entity.solidArea.y = 0;
//        entity.solidArea.width = 32;
//        entity.solidArea.height = 32;
//        entity.speed = 5;
//
//        Entity[] npc = new Entity[1];
//        npc[0] = new Entity(gamePanel);
//        npc[0].worldX = 100;
//        npc[0].worldY = 100;
//        npc[0].direction = "down";
//        npc[0].solidArea.x = 0;
//        npc[0].solidArea.y = 0;
//        npc[0].solidArea.width = 32;
//        npc[0].solidArea.height = 32;
//        npc[0].speed = 5;
//
//        collisionChecker.checkEntity(entity, npc);
//
//        assertFalse(entity.collisionOn);
//    }
//
//    @Test
//    public void testCheckPlayer_collision() {
//        Entity entity = new Entity(gamePanel);
//        entity.worldX = 50;
//        entity.worldY = 50;
//        entity.direction = "down";
//        entity.solidArea.x = 0;
//        entity.solidArea.y = 0;
//        entity.solidArea.width = 32;
//        entity.solidArea.height = 32;
//        entity.speed = 5;
//
//        gamePanel.player.worldX = 50;
//        gamePanel.player.worldY = 100;
//        gamePanel.player.direction = "down";
//        gamePanel.player.solidArea.x = 0;
//        gamePanel.player.solidArea.y = 0;
//        gamePanel.player.solidArea.width = 32;
//        gamePanel.player.solidArea.height = 32;
//
//        collisionChecker.checkPlayer(entity);
//
//        assertTrue(entity.collisionOn);
//    }
//}
