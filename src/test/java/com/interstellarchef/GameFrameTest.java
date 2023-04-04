package com.interstellarchef;

import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameFrameTest {

    @Test
    public void testMapButton() throws IOException {
        GameFrame gameFrame = new GameFrame();
        JButton buttonMap = gameFrame.getButtonMap();

        // Register an ActionListener to the button
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add any assertions or actions you want to test here
                assertEquals("MAP", ((JButton) e.getSource()).getText());
            }
        };
        buttonMap.addActionListener(listener);

        // Simulate a button click
        buttonMap.doClick(0);

        // Wait for the button click event to be fired and the assertion to complete
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // clean up
        gameFrame.dispose();
    }
}

