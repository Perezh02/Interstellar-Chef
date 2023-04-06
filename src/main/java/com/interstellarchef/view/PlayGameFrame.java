//package com.interstellarchef.view;
//
//import com.google.gson.Gson;
//import com.interstellarchef.GameFrame;
//import com.interstellarchef.Main;
//import com.interstellarchef.entity.NPC;
//import com.interstellarchef.gui.GamePanel;
//import java.awt.Dimension;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.Reader;
//import java.util.Objects;
//import javax.imageio.ImageIO;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//
//public class PlayGameFrame {
//
//  PlayGameFrame(GameFrame mainGUI) {
//    this.mainGUI = mainGUI;
//  }
//  GameFrame gameFrame = new GameFrame();
//  JFrame window = new JFrame();
//  GamePanel gamePanel = new GamePanel();
//
//  public void playGamePopUp() {
//
//      window.setSize(new Dimension(800, 600));
//      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      window.setResizable(false);
//      window.setTitle("Interstellar Chef");
//      window.add(gamePanel);
//      window.pack();
//      window.setVisible(true);
//      gamePanel.setupGame();
//      gamePanel.startGameThread();
//      window.setLocationRelativeTo(null); // center the frame on the screen
//      window.setLocation(gameFrame.getX() + gameFrame.getWidth(), gameFrame.getY()); // set location to the right of the main frame
//
//      try(InputStream imageStream = getClass().getClassLoader().getResourceAsStream("spaceship.png")) {
//        assert imageStream != null;
//        BufferedImage buffer = ImageIO.read(imageStream);
//        window.setIconImage(buffer);
//      } catch (IOException ioException) {
//        ioException.printStackTrace();
//      }
//
//
//    }
//}
//
