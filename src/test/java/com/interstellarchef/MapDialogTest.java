//package com.interstellarchef;
//
//import org.junit.jupiter.api.Test;
//
//import javax.swing.*;
//
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class MapDialogTest {
//
//    @Test
//    public void testMapPopUp() throws IOException {
//        // Create a mock GameFrame object
//        GameFrame mockGameFrame = new GameFrame();
//
//        // Create a MapDialog object
//        MapDialog mapDialog = new MapDialog(mockGameFrame);
//
//        // Call the mapPopUp() method
//        mapDialog.mapPopUp();
//
//        // Verify that the JDialog was created with the correct title and is visible
//        JDialog dialog = mapDialog.mapPopUp();
//        assertEquals("MAP", dialog.getTitle());
//        assertTrue(dialog.isVisible());
//
//        // Clean up
//        dialog.dispose();
//    }
//}