package com.interstellarchef.entity;
import static org.junit.jupiter.api.Assertions.*;
import com.interstellarchef.gui.GamePanel;
import com.interstellarchef.gui.KeyHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonsterNPCTest {

  GamePanel gp;
  KeyHandler keyH;
  Player player;
  Entity entity;

  @BeforeEach
  public void initEach() {
    gp = new GamePanel();
    keyH = new KeyHandler();
    player = new Player(gp, keyH);
    entity = new Entity(gp);
  }


  @Test
  public void isAddingRiddleTest() {
    player.riddles[5] = "Test adding another riddle";
    assertEquals("Test adding another riddle", player.riddles[5]);
  }

  @Test
  public void isAddingNullRiddleTest() {
    player.riddles[5] = null;
    assertNull(null, player.riddles[5]);
  }
}