package com.interstellarchef;

import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;
import java.awt.*;


public class MapDialog {
  GameFrame mainGUI;

  public MapDialog(GameFrame mainGUI) {
    this.mainGUI = mainGUI;
  }

  JDialog mapDialog;
  JLabel label1;
  JLabel label2;

  JPanel panelTop = new JPanel();
  JPanel panelCenter = new JPanel();
  JPanel panelBottom = new JPanel();


  public void mapPopUp() {
    mapDialog = new JDialog();
    JPanel panelBg = new JPanel();
    JPanel panelPlanetGif1 = new JPanel();
    JPanel panelSunGif1 = new JPanel();
    panelBg.setBounds(0, 0, 800, 600);
    panelPlanetGif1.setBounds(20,20,250,250);
    panelSunGif1.setBounds(600,400,200, 200);

    try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("InterstellarMapBG.jpg")) {
      byte[] buffer = inputStream.readAllBytes();
      Icon introImage1 = new ImageIcon(buffer);
      JLabel mapImageLabel = new JLabel();
      mapImageLabel.setIcon(introImage1);
      panelBg.add(mapImageLabel);
    } catch (IOException e) {
      e.printStackTrace();
    }

    try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("bluePlanets1.gif")) {
      byte[] buffer = inputStream.readAllBytes();
      Icon planetGifImage1 = new ImageIcon(buffer);
      JLabel planetGifLabel1 = new JLabel();
      planetGifLabel1.setIcon(planetGifImage1);
      panelPlanetGif1.add(planetGifLabel1);
    } catch (IOException e) {
      e.printStackTrace();
    }

    try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sun.gif")) {
      byte[] buffer = inputStream.readAllBytes();
      Icon sunGifImage1 = new ImageIcon(buffer);
      JLabel sunGifLabel1 = new JLabel();
      sunGifLabel1.setIcon(sunGifImage1);
      panelSunGif1.add(sunGifLabel1);
    } catch (IOException e) {
      e.printStackTrace();
    }

    panelPlanetGif1.setOpaque(false);
    panelSunGif1.setOpaque(false);

    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setBounds(0, 0, 800, 600);

    layeredPane.add(panelBg, Integer.valueOf(0));
    layeredPane.add(panelPlanetGif1, Integer.valueOf(1));
    layeredPane.add(panelSunGif1, Integer.valueOf(1));


    mapDialog.setBounds(0, 0, 800, 630);
    mapDialog.add(layeredPane);
    mapDialog.setLocationRelativeTo(null); // center the frame on the screen
    mapDialog.setLocation(this.mainGUI.getX() + this.mainGUI.getWidth(), this.mainGUI.getY()); // set location to the right of the main frame
    mapDialog.setVisible(true);


  }
}




