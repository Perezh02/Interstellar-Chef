package com.interstellarchef;

import com.interstellarchef.gui.GamePanel;
import com.interstellarchef.tile.TileManager;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;


public class MapDialog {
  GameFrame mainGUI;


  GamePanel gp = new GamePanel();


  public MapDialog(GameFrame mainGUI) {
    this.mainGUI = mainGUI;
  }

  JDialog mapDialog = new JDialog();
  int currentLocationNum;
  String currentLocationName;


  public void mapPopUp() {

    JPanel panelBg = new JPanel();
    JPanel panelPlanetGif1 = new JPanel();
    JPanel panelSunGif1 = new JPanel();
    JLabel mapPinLabel = new JLabel();
    panelBg.setBounds(0, 0, 800, 600);
    panelPlanetGif1.setBounds(20,20,250,250);
    panelSunGif1.setBounds(600,400,200, 200);
//    mapPinLabel.setBounds(200,200,100,100);

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

    try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("player/player_down_1.png")) {
      byte[] buffer = inputStream.readAllBytes();
      Icon mapPinIcon = new ImageIcon(buffer);
      mapPinLabel.setIcon(mapPinIcon);
    } catch (IOException ex) {
      ex.printStackTrace();
    }


    currentLocationNum = mainGUI.gamePanel.tileM.locationMap[mainGUI.gamePanel.player.worldX /
        mainGUI.gamePanel.tileSize][mainGUI.gamePanel.player.worldY / mainGUI.gamePanel.tileSize];
    currentLocationName = mainGUI.gamePanel.tileM.getLocationName(currentLocationNum);

    if (currentLocationName.equals("Living Quarters")) {
      mapPinLabel.setBounds(280,360,20,20);
    } else if (currentLocationName.equals("Sector 2")) {
      mapPinLabel.setBounds(580,360,20,20);
    } else if (currentLocationName.equals("Bathroom")) {
      mapPinLabel.setBounds(480, 360, 20, 20);
    }

    mapPinLabel.setOpaque(false);

    panelPlanetGif1.setOpaque(false);
    panelSunGif1.setOpaque(false);
    mapPinLabel.setOpaque(false);

    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setBounds(0, 0, 800, 600);

    layeredPane.add(panelBg, Integer.valueOf(0));
    layeredPane.add(panelPlanetGif1, Integer.valueOf(1));
    layeredPane.add(panelSunGif1, Integer.valueOf(1));
    layeredPane.add(mapPinLabel, Integer.valueOf(1));


    mapDialog.setBounds(0, 0, 800, 630);
    mapDialog.add(layeredPane);
    mapDialog.setLocationRelativeTo(null); // center the frame on the screen
    mapDialog.requestFocus();
    mapDialog.setLocation(this.mainGUI.getX() + this.mainGUI.getWidth(), this.mainGUI.getY()); // set location to the right of the main frame
    mapDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    mapDialog.setModal(true);
    mapDialog.setVisible(true);

  }
  }





