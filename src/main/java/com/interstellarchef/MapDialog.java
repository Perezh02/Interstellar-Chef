package com.interstellarchef;

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
    JPanel panelCenter = new JPanel();
    panelBg.setBounds(0, 0, 800, 600);
    panelCenter.setBounds(0, 100, 800, 400);

    JLabel mapImageLabel = new JLabel();
    Icon introImage1 = new ImageIcon("src/main/resources/Interstellarmap.jpg");
    mapImageLabel.setIcon(introImage1);
    panelBg.add(mapImageLabel);
     //Intro Top Panel
    panelBg.setBackground(Color.BLACK);
    panelCenter.setOpaque(false);

    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setBounds(0, 0, 800, 600);

    layeredPane.add(panelBg, Integer.valueOf(0));
    layeredPane.add(panelCenter, Integer.valueOf(1));

    mapDialog.setBounds(0, 0, 800, 600);
    mapDialog.add(layeredPane);
    mapDialog.setVisible(true);


  }
}




