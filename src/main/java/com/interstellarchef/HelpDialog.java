package com.interstellarchef;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
    label2.setText("<html>  Key options: <b>W, A, S, D, P, I, Space</b> "
            + "<br>  <b>W</b>: Move player up"
            + "<br>  <b>A</b>: Move player left"
            + "<br>  <b>S</b>: Move player down"
            + "<br>  <b>D</b>: Move player right"
            + "<br>  <b>P</b>: Pause game"
            + "<br>  <b>I</b>: Open inventory"
            + "<br>  <b>Space</b>: Use selected item in inventory"
            + "<br><br> Depending on the game state, some keys may not have any effect:"
            + "<br>   - Play state: All keys available including <b>I</b> to open inventory"
            + "<br>   - Pause state: <b>P</b> to unpause and return to play state"
            + "<br>   - Dialogue state: <b>Space</b> to advance dialogue"
            + "<br>   - Inventory state: <b>I</b> to close inventory, <b>W, A, S, D</b> to navigate inventory slots, <b>Space</b> to select an item"
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
