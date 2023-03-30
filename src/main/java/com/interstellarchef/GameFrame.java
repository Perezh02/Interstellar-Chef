package com.interstellarchef;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;

public class GameFrame extends JFrame{

  JLabel label1;
  JButton button;
  JButton buttonSetting;
  JButton buttonQuit;

  protected GameFrame() throws IOException {
    this.setTitle("Interstellar Chef");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(true);
    this.setSize(810,585);
    button = new JButton();

    try(InputStream imageStream = getClass().getClassLoader().getResourceAsStream("spaceship.png")) {
      BufferedImage buffer = ImageIO.read(imageStream);
      this.setIconImage(buffer);
    }
  }


  public void introGUI() throws IOException {

    JPanel panelBg = new JPanel();
    JPanel panelTop = new JPanel();
    JPanel panelCenter = new JPanel();
    JPanel panelBottom = new JPanel();
    panelBg.setBounds(0, 0, 800, 600);
    panelTop.setBounds(0, 0, 800, 100);
    panelCenter.setBounds(0, 100, 800, 400);
    panelBottom.setBounds(0, 500, 800, 100);

    label1 = new JLabel();
    label1.setText("<html><u><b>INTERSTELLAR</b></u> <br>   C. H. E. F.</html>");
    label1.setHorizontalAlignment(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of imageicon
    label1.setVerticalAlignment(JLabel.TOP); // set text TOP, CENTER, BOTTOM of imageicon
    label1.setForeground(new Color(209, 228, 255, 255));
    label1.setFont(new Font("Monospaced", Font.PLAIN, 30));
    Icon introImage1 = new ImageIcon("src/main/resources/chef4.png");
    label1.setIcon(introImage1);
    label1.setIconTextGap(20);

    button.setText("CLICK HERE OR HIT ( ENTER ) TO START");
    button.setFocusable(false);
    button.setHorizontalAlignment(JButton.CENTER);
    button.setVerticalAlignment(JButton.CENTER);
    button.setFont(new Font("Comic Sans", Font.BOLD, 13));
    button.setForeground(Color.WHITE);
    button.setBorder(BorderFactory.createEmptyBorder());
    button.setBackground(new Color(0x365DA2));
    button.setBorder(BorderFactory.createEtchedBorder());
    button.setPreferredSize(new Dimension(300,30));

    // read contents of inputStream into array of bites -> then create imageIcon for that bite instead.
    try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("intro.gif")) {
      byte[] buffer = inputStream.readAllBytes();
      Icon introImage = new ImageIcon(buffer);
      JLabel introImageLabel = new JLabel();
      introImageLabel.setIcon(introImage);
      panelBg.add(introImageLabel);
    }

    // Intro Top Panel
    panelBg.setBackground(Color.BLACK);
    panelCenter.setOpaque(false);

    panelTop.setOpaque(false);
    panelTop.add(label1);
    panelTop.setBorder(new EmptyBorder(5,0,0,0));
    // Intro Bottom Panel

    panelBottom.setOpaque(false);
    panelBottom.add(button);
    panelBottom.setBorder(new EmptyBorder(10,0,0,0));

//    this.getContentPane().add(new JPanelWithBackground("src/main/resources/circling.gif"));

    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setBounds(0,0,800,600);

    layeredPane.add(panelBg,Integer.valueOf(0));
    layeredPane.add(panelTop,Integer.valueOf(3));
    layeredPane.add(panelBottom,Integer.valueOf(2));
    layeredPane.add(panelCenter,Integer.valueOf(1));

    this.add(layeredPane);
    this.setVisible(true);

    KeyListener listener = new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
        System.out.println("key typed");
      }
      @Override
      public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try{
              getContentPane().removeAll();
              repaint();
              startMainGUI();
            } catch (IOException ex) {
              ex.printStackTrace();
            }
        }
      }
      @Override
      public void keyReleased(KeyEvent e) {
      }
    };

    this.addKeyListener(listener);

    button.addActionListener(e -> {
      try {
        this.getContentPane().removeAll();
        this.repaint();
        startMainGUI();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    });
  }





  public void startMainGUI() throws IOException {
    JButton buttonHelp = new JButton();
    buttonHelp.setText("HELP");
    buttonHelp.setFocusable(false);
    buttonHelp.setHorizontalAlignment(JButton.CENTER);
    buttonHelp.setVerticalAlignment(JButton.CENTER);
    buttonHelp.setFont(new Font("Comic Sans", Font.BOLD, 10));
    buttonHelp.setIconTextGap(5);
    buttonHelp.setForeground(Color.WHITE);
    buttonHelp.setBorder(BorderFactory.createEmptyBorder());
    buttonHelp.setBackground(new Color(0x5B90E5));
    buttonHelp.setBorder(BorderFactory.createEtchedBorder());
    buttonHelp.setPreferredSize(new Dimension(150,30));

    JButton buttonSetting = new JButton();
    buttonSetting.setText("SETTINGS");
    buttonSetting.setFocusable(false);
    buttonSetting.setHorizontalAlignment(JButton.CENTER);
    buttonSetting.setVerticalAlignment(JButton.CENTER);
    buttonSetting.setFont(new Font("Comic Sans", Font.BOLD, 10));
    buttonSetting.setIconTextGap(5);
    buttonSetting.setForeground(Color.WHITE);
    buttonSetting.setBorder(BorderFactory.createEmptyBorder());
    buttonSetting.setBackground(new Color(0x5B90E5));
    buttonSetting.setBorder(BorderFactory.createEtchedBorder());
    buttonSetting.setPreferredSize(new Dimension(150,30));

    JButton buttonQuit = new JButton();
    buttonQuit.setText("QUIT");
    buttonQuit.setFocusable(false);
    buttonQuit.setHorizontalAlignment(JButton.CENTER);
    buttonQuit.setVerticalAlignment(JButton.CENTER);
    buttonQuit.setFont(new Font("Comic Sans", Font.BOLD, 10));
    buttonQuit.setIconTextGap(5);
    buttonQuit.setForeground(Color.WHITE);
    buttonQuit.setBorder(BorderFactory.createEmptyBorder());
    buttonQuit.setBackground(new Color(0x5B90E5));
    buttonQuit.setBorder(BorderFactory.createEtchedBorder());
    buttonQuit.setPreferredSize(new Dimension(150,30));


//     Button Action Listener calling HelpDialog PopUp
    buttonHelp.addActionListener(e -> new HelpDialog(this).helpPopUp());

    JPanel panelBg = new JPanel();
    JPanel panelTop = new JPanel();
    JPanel panelMain = new JPanel();
    JPanel panelTextInput = new JPanel();
    JPanel panelRightTop = new JPanel();
    JPanel panelRightBottom = new JPanel();

    panelBg.setBounds(0, 0, 800, 600);

    panelTop.setBounds(0, 0, 800, 50);
    panelMain.setBounds(0, 50, 500, 450);
    panelRightTop.setBounds(500, 50, 300, 300);
    panelTextInput.setBounds(0, 500, 500, 50);
    panelRightBottom.setBounds(500, 350, 300, 200);

    panelTop.setBorder(new EmptyBorder(5,0,0,0));

    panelTextInput.setBackground(new Color(0x6225B0C7, true));
    panelRightTop.setBackground(new Color(0x9A6F9A));
    panelRightBottom.setBackground(new Color(0xAD8EB688, true));
    panelMain.setBackground(new Color(0xC8DEFF));

    JLabel gameDescriptionLabel = new JLabel();
    gameDescriptionLabel.setText("<html>"
        + "<h2>Hello Culinary Cosmonauts!</h2> <br>"
        +"Welcome aboard the International Chef Station, where we have one goal:<br><br>"
        +"To train under the Head Chef,and home the foraging skills needed to be a <br>"
        +"skilled gatherer of ingredients. At the start of the game, <br>"
        +"you will be in your living quarters (be sure to put your uniform on)!<br>"
        +"Head straight to the kitchen to get your recipe assignment from the chef.<br>"
        +"From there you should check every room and crevice, and talk to everyone <br>"
        +"you meet to find those ingredients/valuable things to trade.<br>"
        +"Finally: The Discovery Pod is the gateway to discovering neighboring planets!<br>"
        +"Beware of monsters, but interacting with them might yield something interesting.<br>"
        +"That's all for now, Chef! Good luck out there!<br><br>"
        +"<h3>TYPE ANY COMMANDS OR PRESS BUTTONS TO START THE GAME.<h3><br>"

        + "</html>");

    gameDescriptionLabel.setHorizontalAlignment(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of imageicon
    gameDescriptionLabel.setVerticalAlignment(JLabel.TOP); // set text TOP, CENTER, BOTTOM of imageicon
    gameDescriptionLabel.setForeground(new Color(0, 0, 0, 255));
    gameDescriptionLabel.setFont(new Font("Comic Sans", Font.PLAIN, 13));

    panelMain.add(gameDescriptionLabel);


//    panelRightBottom.add(arrowEast);
//    panelRightBottom.add(arrowNorth);
//    panelRightBottom.add(arrowSouth);


//    ImageIcon icon = new ImageIcon("src/main/resources/bg11.jpg");
//    JButton panelButton1 = new JButton(icon);
//    ImageIcon icon2 = new ImageIcon("src/main/resources/bg11.jpg");
//    JButton panelButton2 = new JButton(icon2);
//    ImageIcon icon3 = new ImageIcon("src/main/resources/bg11.jpg");
//    JButton panelButton3 = new JButton(icon3);
//    ImageIcon icon4 = new ImageIcon("src/main/resources/bg11.jpg");
//    JButton panelButton4 = new JButton(icon4);

//    panelRightBottom.setLayout(new BorderLayout());
//    panelRightBottom.add(panelButton1, BorderLayout.EAST);
//    panelRightBottom.add(panelButton2, BorderLayout.WEST);
//    panelRightBottom.add(panelButton3, BorderLayout.SOUTH);
//    panelRightBottom.add(panelButton4, BorderLayout.NORTH);

    // Building direction buttons
    panelRightBottom.setLayout(new GridLayout(3,3));
    JButton directionButton1 = new JButton("1");
    JButton directionButton2 = new JButton("NORTH");
    JButton directionButton3 = new JButton("3");
    JButton directionButton4 = new JButton("WEST");
    JButton directionButton5 = new JButton("5");
    JButton directionButton6 = new JButton("EAST");
    JButton directionButton7 = new JButton("7");
    JButton directionButton8 = new JButton("SOUTH");
    JButton directionButton9 = new JButton("9");
    directionButton1.setVisible(false);
    directionButton3.setVisible(false);
    directionButton5.setVisible(false);
    directionButton7.setVisible(false);
    directionButton9.setVisible(false);
    directionButton2.setBorder(BorderFactory.createEtchedBorder());
    directionButton4.setBorder(BorderFactory.createEtchedBorder());
    directionButton6.setBorder(BorderFactory.createEtchedBorder());
    directionButton8.setBorder(BorderFactory.createEtchedBorder());
    directionButton2.setBackground(new Color(0x80ADFF));
    directionButton4.setBackground(new Color(0x80ADFF));
    directionButton6.setBackground(new Color(0x80ADFF));
    directionButton8.setBackground(new Color(0x80ADFF));
    directionButton2.setFocusable(false);
    directionButton4.setFocusable(false);
    directionButton6.setFocusable(false);
    directionButton8.setFocusable(false);

    panelRightBottom.add(directionButton1);
    panelRightBottom.add(directionButton2);
    panelRightBottom.add(directionButton3);
    panelRightBottom.add(directionButton4);
    panelRightBottom.add(directionButton5);
    panelRightBottom.add(directionButton6);
    panelRightBottom.add(directionButton7);
    panelRightBottom.add(directionButton8);
    panelRightBottom.add(directionButton9);



    JLabel label2 = new JLabel();
    label2.setHorizontalAlignment(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of imageicon
    label2.setVerticalAlignment(JLabel.TOP); // set text TOP, CENTER, BOTTOM of imageicon

    JTextArea inventoryTextArea = new JTextArea(10,27);
    inventoryTextArea.append("- Current Location: DATA FROM JSON\n" );
    inventoryTextArea.append("- Available Exits: east: DATA FROM JSON\n");
    inventoryTextArea.append("- Items in current location: DATA FROM JSON\n");
    inventoryTextArea.append("- Characters in current location: DATA FROM JSON\n");
    inventoryTextArea.append("- Monster in current location: DATA FROM JSON\n");
    inventoryTextArea.append("- Currently equipped item: DATA FROM JSON\n");

    inventoryTextArea.setLineWrap(true);

    panelRightTop.add(inventoryTextArea);
    panelTop.add(buttonHelp);
    panelTop.add(buttonSetting);
    panelTop.add(buttonQuit);



    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setBounds(0,0,800,600);

    layeredPane.add(panelBg,Integer.valueOf(0));
    layeredPane.add(panelTop,Integer.valueOf(3));
    layeredPane.add(panelMain,Integer.valueOf(4));
    layeredPane.add(panelRightTop,Integer.valueOf(1));
    layeredPane.add(panelRightBottom,Integer.valueOf(5));
    layeredPane.add(panelTextInput,Integer.valueOf(2));

    this.add(layeredPane);
    this.setVisible(true);

  }
}
