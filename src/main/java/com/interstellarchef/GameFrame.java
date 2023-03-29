package com.interstellarchef;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GameFrame extends JFrame{

  JLabel label1;
  JButton button;
  JButton buttonSetting;
  JButton buttonQuit;

  protected GameFrame() throws IOException {
    this.setTitle("Interstellar Chef");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(true);
    this.setSize(900,750);
    button = new JButton();
    // Icon top left
    // ImageIO Library


    try(InputStream imageStream = getClass().getClassLoader().getResourceAsStream("spaceship.png")) {
      //noinspection ConstantConditions
      BufferedImage buffer = ImageIO.read(imageStream);
      this.setIconImage(buffer);
    }
  }

  //SetBackgroundImage
  //Jlabel -> icon into Jlabel -> Expand the image to fit into the panel



  public void introGUI() throws IOException {

    JPanel panelTop = new JPanel();
    JPanel panelCenter = new JPanel();
    JPanel panelBottom = new JPanel();

    this.setLayout(new BorderLayout(0,0));

    this.add(panelTop, BorderLayout.NORTH);
    this.add(panelBottom, BorderLayout.SOUTH);
    this.add(panelCenter, BorderLayout.CENTER);

    label1 = new JLabel();
    label1.setText("<html><u><b>INTERSTELLAR</b></u> <br>   C. H. E. F.</html>");
    label1.setHorizontalAlignment(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of imageicon
    label1.setVerticalAlignment(JLabel.TOP); // set text TOP, CENTER, BOTTOM of imageicon
    label1.setForeground(new Color(209, 228, 255, 255));
    label1.setFont(new Font("Monospaced", Font.PLAIN, 40));
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

    // Intro Center Image Panel
    panelCenter.setBackground(new Color(0xFF000001, true));
    panelCenter.setPreferredSize(new Dimension(500, 30));

    // read contents of inputStream into array of bites -> then create imageIcon for that bite instead.
    try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("intro.gif")) {
      byte[] buffer = inputStream.readAllBytes();
      Icon introImage = new ImageIcon(buffer);
      JLabel introImageLabel = new JLabel();
      introImageLabel.setIcon(introImage);
      panelCenter.add(introImageLabel);
    }
    // Intro Top Panel
    panelTop.setBackground(new Color(0xFF3B6CBE, true));
    panelTop.setPreferredSize(new Dimension(500, 150));
    panelTop.add(label1);
    panelTop.setBorder(new EmptyBorder(20,0,0,0));
    // Intro Bottom Panel
    panelBottom.setBackground(new Color(0xFF1C3660, true));
    panelBottom.setPreferredSize(new Dimension(500, 100));
    panelBottom.add(button);
    panelBottom.setBorder(new EmptyBorder(20,0,0,0));


//    this.getContentPane().add(new JPanelWithBackground("src/main/resources/circling.gif"));

    // EventListener for keyStroke (set to Enter Only)
    this.setVisible(true);
    this.addKeyListener(new KeyStrokeHandler());


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

    JPanel panelTop = new JPanel();

    JPanel panelRight = new JPanel();
    JPanel panelBottom = new JPanel();
    JPanel panelMain = new JPanel();

//    panelTop.setBackground(new Color(0xFFD8E7FF, true));
    panelBottom.setBackground(new Color(0x7608849F, true));
    panelMain.setBackground(new Color(0x5EA4A4));

    panelTop.setPreferredSize(new Dimension(500, 35));

    panelRight.setPreferredSize(new Dimension(300, 100));
//    panelBottom.setPreferredSize(new Dimension(100, 50));
    panelMain.setPreferredSize(new Dimension(100, 100));





  // Setting margin for borderLayout
    this.setLayout(new BorderLayout(10,10));
    this.add(panelTop, BorderLayout.NORTH);
    this.add(panelRight, BorderLayout.EAST);
    this.add(panelMain, BorderLayout.CENTER);

    // Adding GridLayout for center
    panelRight.setLayout(new GridLayout(2,1, 10, 10));
    JPanel panelRightTop = new JPanel();
    JPanel panelRightBottom = new JPanel();


    panelMain.setLayout(new BorderLayout());
    JPanel panelMainTop = new JPanel();
    JPanel panelMainBottom = new JPanel();
    panelMain.add(panelMainTop, BorderLayout.CENTER);
    panelMain.add(panelMainBottom, BorderLayout.SOUTH);

    panelMainTop.setPreferredSize(new Dimension(450,400));
    panelMainTop.setBackground(new Color(211, 227, 255));

    panelMainBottom.setBackground(new Color(156, 182, 206));
    panelMainBottom.setPreferredSize(new Dimension(300,100));


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
//    gameDescriptionLabel.setVerticalAlignment(JLabel.TOP); // set text TOP, CENTER, BOTTOM of imageicon
//    gameDescriptionLabel.setForeground(new Color(0, 0, 0, 255));
    gameDescriptionLabel.setFont(new Font("Comic Sans", Font.PLAIN, 13));


    panelMainTop.add(gameDescriptionLabel);





    // 2 Panels on the right side of screen
//    panelRightTop.setBackground(new Color(0xAD116404, true));
//    panelRightBottom.setBackground(new Color(0x5787B97E, true));

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




    panelRight.add(panelRightTop);
    panelRight.add(panelRightBottom);




    JLabel label2 = new JLabel();
//    label2.setText("<html>Top Right corner. <br>Maybe show item/character, etc description (HELP)<html>");
    label2.setHorizontalAlignment(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of imageicon
    label2.setVerticalAlignment(JLabel.TOP); // set text TOP, CENTER, BOTTOM of imageicon
    label2.setForeground(new Color(19, 36, 63, 255));






    JTextArea inventoryTextArea = new JTextArea(10,27);
    inventoryTextArea.append("- Current Location: DATA FROM JSON\n" );
    inventoryTextArea.append("- Available Exits: east: DATA FROM JSON\n");
    inventoryTextArea.append("- Items in current location: DATA FROM JSON\n");
    inventoryTextArea.append("- Characters in current location: DATA FROM JSON\n");
    inventoryTextArea.append("- Monster in current location: DATA FROM JSON\n");
    inventoryTextArea.append("- Currently equipped item: DATA FROM JSON\n");


    inventoryTextArea.setLineWrap(true);




    panelRightTop.add(inventoryTextArea);



//    Icon mainBottomImage = new ImageIcon("src/main/resources/outerspace3.gif");
//    JLabel mainBottomImageLabel = new JLabel();
//    mainBottomImageLabel.setIcon(mainBottomImage);
//    panelTop.add(mainBottomImageLabel);


//    JTextArea testField = new JTextArea();
//
//    System.out.println("hello");
//    testField.append("hello");

//
//    panelTop.add(testField);

    panelTop.add(buttonHelp);
    panelTop.add(buttonSetting);
    panelTop.add(buttonQuit);


    this.setVisible(true);

  }
}
