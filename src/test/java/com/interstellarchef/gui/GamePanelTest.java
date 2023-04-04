package com.interstellarchef.gui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GamePanelTest {

  @Test
  void isMusicPlayingForInPlanet_true() {
    GamePanel gamePanel = new GamePanel();
    gamePanel.eHandler.isInPlanet = true;
    assertTrue(gamePanel.eHandler.isInPlanet());
    }

  @Test
  void isMusicPlayingForInPlanet_false() {
    GamePanel gamePanel = new GamePanel();
    gamePanel.eHandler.isInPlanet = false;
    assertFalse(gamePanel.eHandler.isInPlanet());
  }



}