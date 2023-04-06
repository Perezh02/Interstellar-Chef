package com.interstellarchef;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HelpDialog {
  GameFrame mainGUI;

  HelpDialog(GameFrame mainGUI) {
    this.mainGUI = mainGUI;
  }

  JDialog helpDialog;
  JLabel label1;
  JLabel label2;
  JButton buttonHelp;


  public void helpPopUp() {

    helpDialog = new JDialog(mainGUI, "GAME INFORMATION CENTER", true);
    helpDialog.setLayout(new BorderLayout(0, 0));
    JPanel panelTop = new JPanel();
    JPanel panelCenter = new JPanel();
    JPanel panelBottom = new JPanel();
    helpDialog.add(panelTop, BorderLayout.NORTH);
    helpDialog.add(panelBottom, BorderLayout.SOUTH);
    helpDialog.add(panelCenter, BorderLayout.CENTER);
    helpDialog.setSize(800, 600);


    helpDialog.setLocationRelativeTo(null); // center the frame on the screen
    helpDialog.setLocation(this.mainGUI.getX() + this.mainGUI.getWidth(), this.mainGUI.getY()); // set location to the right of the main frame


    label1 = new JLabel();
    label1.setText("<html>* H E L P *<br> </html>");
    label1.setHorizontalAlignment(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of imageicon
    label1.setVerticalAlignment(JLabel.TOP); // set text TOP, CENTER, BOTTOM of imageicon
    label1.setForeground(new Color(209, 228, 255, 255));
    label1.setFont(new Font("Comic Sans", Font.BOLD, 40));

    label2 = new JLabel();
    label2.setText("<html> &nbsp;Direction options: <b>North, South, West, East, Up & Down</b> "
        + "<br> &nbsp;<b>go</b> <Direction>: Moves character in selected direction "
        + "<br> &nbsp;<b>get</b> <Item Name>: Adds item in the current location to Player's Inventory"
        + "<br> &nbsp;<b>look</b> <Item/Location/Character/Monster Name>/Inventory: Investigates Item, Location, Character or Monster, or displays player's inventory"
        + "<br> &nbsp;<b>equip</b> <Item Name>: item disappears from your inventory and is set as the player's equipped item"
        + "<br> &nbsp;<b>drop</b> <Item Name>: item is dropped onto the floor of the current location"
        + "<br> &nbsp;<b>talk</b> <Character Name>/<Monster Name>: Starts conversation with Character"
        + "<br> &nbsp;<b>fly Discovery Pod</b>: Requires key, GPS and equipped spacesuit in Discovery Pod. Allows user to fly to other planets."
        + "<br> &nbsp;<b>toggle music</b>: Allows player to toggle music on/off."
        + "<br> &nbsp;<b>volume up/down</b>: Allows player to adjust music volume."
        + "<br> &nbsp;<b>help</b>: Displays a list of valid commands"
        + "<br> &nbsp;<b>quit</b>: prompts user if they would like to end the game"
        + "</html>");
    label2.setHorizontalAlignment(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of imageicon
    label2.setVerticalAlignment(JLabel.TOP); // set text TOP, CENTER, BOTTOM of imageicon
    label2.setForeground(new Color(0, 0, 0, 255));
    label2.setFont(new Font("Comic Sans", Font.PLAIN, 13));
    label2.setBorder(new EmptyBorder(5,5,5,5));

    buttonHelp = new JButton();
    buttonHelp.setText("CLICK TO CLOSE");
    buttonHelp.setFocusable(false);
    buttonHelp.setHorizontalAlignment(JButton.CENTER);
    buttonHelp.setVerticalAlignment(JButton.CENTER);
    buttonHelp.setFont(new Font("Comic Sans", Font.BOLD, 13));
    buttonHelp.setForeground(Color.WHITE);
    buttonHelp.setBorder(BorderFactory.createEmptyBorder());
    buttonHelp.setBackground(new Color(0x365DA2));
    buttonHelp.setBorder(BorderFactory.createEtchedBorder());
    buttonHelp.setPreferredSize(new Dimension(300, 30));

    buttonHelp.addActionListener(e -> helpDialog.setVisible(false));

    panelTop.setBackground(new Color(0xFF1C3660, true));
    panelBottom.setBackground(new Color(0xFF1C3660, true));

    panelTop.setPreferredSize(new Dimension(700, 100));
    panelTop.add(label1);
    panelTop.setBorder(new EmptyBorder(20, 0, 0, 0));

    panelCenter.setPreferredSize(new Dimension(500, 350));
    panelCenter.add(label2);
    panelCenter.setBorder(new EmptyBorder(40, 0, 0, 0));

    panelBottom.setPreferredSize(new Dimension(700, 100));
    panelBottom.add(buttonHelp);
    panelBottom.setBorder(new EmptyBorder(20, 0, 0, 0));

//    helpDialog.add(this.buttons());
    buttons();
    helpDialog.setVisible(true);









  }

  public Component buttons() {
    buttonHelp = new JButton();
    buttonHelp.setText("CLICK TO CLOSE");
    buttonHelp.setFocusable(false);
    buttonHelp.setHorizontalAlignment(JButton.CENTER);
    buttonHelp.setVerticalAlignment(JButton.CENTER);
    buttonHelp.setFont(new Font("Comic Sans", Font.BOLD, 13));
    buttonHelp.setForeground(Color.WHITE);
    buttonHelp.setBorder(BorderFactory.createEmptyBorder());
    buttonHelp.setBackground(new Color(0x365DA2));
    buttonHelp.setBorder(BorderFactory.createEtchedBorder());
    buttonHelp.setPreferredSize(new Dimension(300, 30));




    return buttonHelp;
  }



  }
