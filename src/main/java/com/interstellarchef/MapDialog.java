package com.interstellarchef;

import com.interstellarchef.gui.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class MapDialog {
  GameFrame mainGUI;

  public MapDialog(GameFrame mainGUI) {
    this.mainGUI = mainGUI;
  }

  GamePanel gp = new GamePanel();
  JDialog mapDialog;


  public JDialog mapPopUp() {


    if (gp.tileM == null || gp.player == null) {
      System.err.println("Error: game components not initialized");
      return null;
    }
    mapDialog = new JDialog();
    JPanel panelBg = new JPanel();
    JPanel panelPlanetGif1 = new JPanel();
    JPanel panelSunGif1 = new JPanel();
    JLabel mapPinIcon = new JLabel();
    panelBg.setBounds(0, 0, 800, 600);
    panelPlanetGif1.setBounds(20, 20, 250, 250);
    panelSunGif1.setBounds(600, 400, 200, 200);

    mapPinIcon.setBounds(600, 400, 200, 200);

    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("InterstellarMapBG.jpg")) {
      byte[] buffer = inputStream.readAllBytes();
      Icon introImage1 = new ImageIcon(buffer);
      JLabel mapImageLabel = new JLabel();
      mapImageLabel.setIcon(introImage1);
      panelBg.add(mapImageLabel);
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("bluePlanets1.gif")) {
      byte[] buffer = inputStream.readAllBytes();
      Icon planetGifImage1 = new ImageIcon(buffer);
      JLabel planetGifLabel1 = new JLabel();
      planetGifLabel1.setIcon(planetGifImage1);
      panelPlanetGif1.add(planetGifLabel1);
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sun.gif")) {
      byte[] buffer = inputStream.readAllBytes();
      Icon sunGifImage1 = new ImageIcon(buffer);
      JLabel sunGifLabel1 = new JLabel();
      sunGifLabel1.setIcon(sunGifImage1);
      panelSunGif1.add(sunGifLabel1);
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("player/player_down_1.png")) {
      byte[] buffer = inputStream.readAllBytes();
      ImageIcon mapPinIconImage = new ImageIcon(buffer);
      ImageIcon scaledMapPinIconImage = new ImageIcon(mapPinIconImage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
      mapPinIcon.setIcon(scaledMapPinIconImage);
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
    layeredPane.add(mapPinIcon, Integer.valueOf(2));


    int currentLocationNum = mainGUI.gamePanel.tileM.locationMap[mainGUI.gamePanel.player.worldX / mainGUI.gamePanel.tileSize][mainGUI.gamePanel.player.worldY / mainGUI.gamePanel.tileSize];
    String currentLocationName = mainGUI.gamePanel.tileM.getLocationName(currentLocationNum);
    System.out.println(currentLocationName);


    if (currentLocationName.equals("Living Quarters")) {
      mapPinIcon.setBounds(280, 360, 20, 20);
    } else if (currentLocationName.equals("Sector 2")) {
      mapPinIcon.setBounds(400, 370, 20, 20);
    } else if (currentLocationName.equals("Bathroom")) {
      mapPinIcon.setBounds(455, 360, 20, 20);
    } else if (currentLocationName.equals("Discovery Pod")) {
      mapPinIcon.setBounds(410, 70, 20, 20);
    } else if (currentLocationName.equals("Command Center")) {
      mapPinIcon.setBounds(330, 165, 20, 20);
    } else if (currentLocationName.equals("Sector 4")) {
      mapPinIcon.setBounds(400, 165, 20, 20);
    } else if (currentLocationName.equals("Engineering Spaces")) {
      mapPinIcon.setBounds(455, 168, 20, 20);
    } else if (currentLocationName.equals("Info. Center")) {
      mapPinIcon.setBounds(325, 230, 20, 20);
    } else if (currentLocationName.equals("Sector 3")) {
      mapPinIcon.setBounds(400, 240, 20, 20);
    } else if (currentLocationName.equals("Med Bay")) {
      mapPinIcon.setBounds(465, 230, 20, 20);
    } else if (currentLocationName.equals("Mess Hall")) {
      mapPinIcon.setBounds(400, 300, 20, 20);
    } else if (currentLocationName.equals("Kitchen")) {
      mapPinIcon.setBounds(470, 300, 20, 20);
    } else if (currentLocationName.equals("Gym")) {
      mapPinIcon.setBounds(285, 450, 20, 20);
    } else if (currentLocationName.equals("Sector 1")) {
      mapPinIcon.setBounds(400, 450, 20, 20);
    } else if (currentLocationName.equals("Pressurized Garden")) {
      mapPinIcon.setBounds(475, 450, 20, 20);
    } else if (currentLocationName.equals("Floating Garden")) {
      mapPinIcon.setBounds(400, 550, 20, 20);
    }

    mapPinIcon.setOpaque(false);
    mapDialog.setBounds(0, 0, 800, 630);
    mapDialog.add(layeredPane);
    mapDialog.setLocationRelativeTo(null); // center the frame on the screen
    mapDialog.setLocation(this.mainGUI.getX() + this.mainGUI.getWidth(), this.mainGUI.getY()); // set location to the right of the main frame
    mapDialog.setModal(true);
    mapDialog.setVisible(true);
    return null;
  }
}





