package com.interstellarchef;

import com.interstellarchef.util.MusicPlayer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class SettingDialog {
  GameFrame mainGUI;

  SettingDialog(GameFrame mainGUI) {
    this.mainGUI = mainGUI;
  }

  JDialog helpDialog;
  JLabel label1;
  JLabel label2;
  JButton buttonHelp;
  JPanel panelTop = new JPanel();
  JPanel panelCenter = new JPanel();
  JPanel panelBottom = new JPanel();

  MusicPlayer music = new MusicPlayer();



  public void settingPopUp() {


    helpDialog = new JDialog(mainGUI, "SETTINGS", true);
    helpDialog.setLayout(new BorderLayout(0, 0));
    helpDialog.add(panelTop, BorderLayout.NORTH);
    helpDialog.add(panelBottom, BorderLayout.SOUTH);
    helpDialog.add(panelCenter, BorderLayout.CENTER);
    helpDialog.setSize(810, 585);

    helpDialog.setLocationRelativeTo(null); // center the frame on the screen
    helpDialog.setLocation(this.mainGUI.getX() + this.mainGUI.getWidth(), this.mainGUI.getY()); // set location to the right of the main frame

    label1 = new JLabel();
    label1.setText("<html>* SETTINGS *<br> </html>");
    label1.setHorizontalAlignment(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of imageicon
    label1.setVerticalAlignment(JLabel.TOP); // set text TOP, CENTER, BOTTOM of imageicon
    label1.setForeground(new Color(209, 228, 255, 255));
    label1.setFont(new Font("Comic Sans", Font.BOLD, 40));

    label2 = new JLabel();
//    label2.setText("<html> Volume controls </b> "
//        + "<br>Implement volume control on/off/up/down "
//        + "</html>");
    label2.setHorizontalAlignment(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of imageicon
    label2.setVerticalAlignment(JLabel.TOP); // set text TOP, CENTER, BOTTOM of imageicon
    label2.setForeground(new Color(0, 0, 0, 255));
    label2.setFont(new Font("Comic Sans", Font.PLAIN, 13));

    JButton buttonCloseDialog = buttonLayout("CLICK TO CLOSE", new Color(0x365DA2), new Dimension(300, 30));

    buttonCloseDialog.addActionListener(e -> helpDialog.setVisible(false));

    panelTop.setBackground(new Color(0xFF1C3660, true));
    panelBottom.setBackground(new Color(0xFF1C3660, true));

    panelTop.setPreferredSize(new Dimension(700, 100));
    panelTop.add(label1);
    panelTop.setBorder(new EmptyBorder(20, 0, 0, 0));

    panelCenter.setPreferredSize(new Dimension(500, 350));
    panelCenter.add(label2);
    panelCenter.setBorder(new EmptyBorder(40, 0, 0, 0));

    panelBottom.setPreferredSize(new Dimension(700, 100));
    panelBottom.add(buttonCloseDialog);
    panelBottom.setBorder(new EmptyBorder(20, 0, 0, 0));

    JButton volumeUpButton = buttonLayout("Volume Up", new Color(0x365DA2), new Dimension(120, 100));
    JButton volumeDownButton = buttonLayout("Volume Down", new Color(0x365DA2), new Dimension(120, 100));
    JButton toggleMusic = buttonLayout("Toggle Music", new Color(0x4FA99C), new Dimension(120, 100));

    volumeUpButton.addActionListener(e->{
      mainGUI.gamePanel.musicIncrease();
    });

    volumeDownButton.addActionListener(e->{
      mainGUI.gamePanel.musicDecrease();
    });

    toggleMusic.addActionListener(e-> {
      if (!mainGUI.gamePanel.isMusicPlaying()) {
        if(mainGUI.gamePanel.eHandler.isInPlanet) {
          mainGUI.gamePanel.playMusic(1);
        } else {
          mainGUI.gamePanel.playMusic(0);
        }
      }
      mainGUI.gamePanel.toggleMusic();
    });

    panelCenter.add(volumeUpButton);
    panelCenter.add(volumeDownButton);
    panelCenter.add(toggleMusic);

    helpDialog.setVisible(true);

  }

  public JButton buttonLayout(String text, Color color, Dimension size) {
    JButton button = new JButton();
    button.setText(text);
    button.setFocusable(false);
    button.setHorizontalAlignment(JButton.CENTER);
    button.setVerticalAlignment(JButton.CENTER);
    button.setFont(new Font("Comic Sans", Font.BOLD, 13));
    button.setForeground(Color.WHITE);
    button.setBorder(BorderFactory.createEmptyBorder());
    button.setBackground(color);
    button.setBorder(BorderFactory.createEtchedBorder());
    button.setPreferredSize(size);

    return button;
  }

  }
