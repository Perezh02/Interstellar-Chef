package com.interstellarchef;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MapLocationTest {

    GameFrame mainGUI;
    int currentLocationNum;
    String currentLocationName;

    @BeforeEach
    public void init() throws IOException {
        mainGUI = new GameFrame();
        currentLocationName = mainGUI.gamePanel.tileM.getLocationName(currentLocationNum);

    }

    @Test
    public void isLocationSameTest() {
        currentLocationNum = 1;
        currentLocationName = mainGUI.gamePanel.tileM.getLocationName(currentLocationNum);
        assertEquals("Living Quarters", currentLocationName);

    }

    @Test
    public void isLocationNotSameTest() {
        currentLocationNum = 2;
        currentLocationName = mainGUI.gamePanel.tileM.getLocationName(currentLocationNum);
        assertNotEquals("Living Quarters", currentLocationName);

    }

}
