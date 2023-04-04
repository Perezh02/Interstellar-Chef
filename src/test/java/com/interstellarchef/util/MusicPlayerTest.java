package com.interstellarchef.util;

import com.interstellarchef.gui.GamePanel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MusicPlayerTest {
    @Test
    void isMusicNotNull() {
        GamePanel gamePanel = new GamePanel(); assertNotNull(gamePanel.music); }

    @Test void isMusicNotPlaying() {
        GamePanel gamePanel = new GamePanel(); gamePanel.musicPlaying = false;
        assertTrue(!gamePanel.isMusicPlaying()); }
}