package com.interstellarchef;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JFrame;


public class KeyStrokeHandler extends JFrame implements KeyListener{

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.getContentPane().removeAll();
            this.repaint();
            try {
                GameFrame mainGUI = new GameFrame();
                mainGUI.startMainGUI();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }



    public void keyReleased(KeyEvent e) {
        System.out.println("key released");
    }
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");
    }

}