package com.interstellarchef;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JFrame;


public class KeyStrokeHandler extends JFrame implements KeyListener{

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try{
                this.getContentPane().removeAll();
                this.repaint();
                GameFrame gameFrame = new GameFrame();
                gameFrame.startMainGUI();
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