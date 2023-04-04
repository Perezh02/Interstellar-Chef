package com.interstellarchef.tile;

import static org.junit.jupiter.api.Assertions.*;

import com.interstellarchef.gui.GamePanel;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TileManagerTest {

    private TileManager tileManager;

    @BeforeEach
    void setUp() {
        tileManager = new TileManager(new GamePanel());
        Map<Integer, String> areaNames = new HashMap<>();
        areaNames.put(1, "Living Quarters");
        areaNames.put(2, "Sector 1");
        areaNames.put(3, "Bathroom");
        tileManager.areaNames = areaNames;
    }

    @Test
    void testValidLocationNum() {
        String locationName = tileManager.getLocationName(2);
        assertEquals("Area 2", locationName);
    }

    @Test
    void testInvalidLocationNum() {
        String locationName = tileManager.getLocationName(4);
        assertEquals("", locationName);
    }
}