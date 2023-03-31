package com.interstellarchef;

import com.interstellarchef.controller.GameController;
import com.interstellarchef.util.MusicPlayer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GameFrame extends JFrame{

  JLabel label1;
  JButton button;

  MusicPlayer musicPlayer = new MusicPlayer();

  JButton buttonMap;
  JLabel timerLabel;
  private int timerSeconds;

  protected GameFrame() throws IOException {
    this.setTitle("Interstellar Chef");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setSize(810,585);
    button = new JButton();

    musicPlayer.play();


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

    JButton buttonQuit = new JButton();
    buttonQuit.setText("QUIT");
    buttonQuit.setFocusable(false);
    buttonQuit.setHorizontalAlignment(JButton.CENTER);
    buttonQuit.setVerticalAlignment(JButton.CENTER);
    buttonQuit.setFont(new Font("Comic Sans", Font.BOLD, 10));
    buttonQuit.setIconTextGap(5);
    buttonQuit.setForeground(Color.WHITE);
    buttonQuit.setBorder(BorderFactory.createEmptyBorder());
    buttonQuit.setBackground(new Color(0xB45D5D));
    buttonQuit.setBorder(BorderFactory.createEtchedBorder());
    buttonQuit.setPreferredSize(new Dimension(100, 30));

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
    buttonHelp.setPreferredSize(new Dimension(100, 30));

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
    buttonSetting.setPreferredSize(new Dimension(100, 30));

    JButton buttonMap = new JButton();
    buttonMap.setText("MAP");
    buttonMap.setFocusable(false);
    buttonMap.setHorizontalAlignment(JButton.CENTER);
    buttonMap.setVerticalAlignment(JButton.CENTER);
    buttonMap.setFont(new Font("Comic Sans", Font.BOLD, 10));
    buttonMap.setIconTextGap(5);
    buttonMap.setForeground(Color.WHITE);
    buttonMap.setBorder(BorderFactory.createEmptyBorder());
    buttonMap.setBackground(new Color(0x5B90E5));
    buttonMap.setBorder(BorderFactory.createEtchedBorder());
    buttonMap.setPreferredSize(new Dimension(100, 30));

    buttonMap.addActionListener(e -> {
      JFrame mapFrame = new JFrame("Map");
      ImageIcon mapImage = new ImageIcon("path/to/map/image.png");
      JLabel mapLabel = new JLabel(mapImage);
      mapFrame.add(mapLabel);
      mapFrame.setSize(800, 600); // set size of the frame
      mapFrame.setResizable(false); // prevent resizing
      mapFrame.setLocationRelativeTo(null); // center the frame on the screen
      mapFrame.setLocation(GameFrame.this.getX() + GameFrame.this.getWidth(), GameFrame.this.getY()); // set location to the right of the main frame
      mapFrame.setVisible(true);
    });

    // create a custom font for the timer label
    Font spaceFont = new Font("Arial", Font.BOLD, 25);
    // create a custom color for the timer label
    Color spaceColor = new Color(51, 0, 102); // dark blue

    // create the timer label with the custom font and color
    JLabel timerLabel = new JLabel("00:00");
    timerLabel.setFont(spaceFont);
    timerLabel.setForeground(spaceColor);

    // create the timer object
    Timer timer = new Timer(1000, e -> {
      timerSeconds++;
      int minutes = timerSeconds / 60;
      int seconds = timerSeconds % 60;
      String minutesStr = String.format("%02d", minutes);
      String secondsStr = String.format("%02d", seconds);
      timerLabel.setText(minutesStr + ":" + secondsStr);
    });
    timer.start();




//     Button Action Listener calling HelpDialog PopUp
    buttonHelp.addActionListener(e -> new HelpDialog(this).helpPopUp());
    buttonSetting.addActionListener(e -> new SettingDialog(this).settingPopUp());
    buttonQuit.addActionListener(e -> System.exit(0));



    JPanel panelBg = new JPanel();
    JPanel panelTop = new JPanel();
    JPanel panelMain = new JPanel();
    JPanel panelRight = new JPanel();
    JPanel panelRightTop = new JPanel();
    JPanel panelRightMiddle = new JPanel();
    JPanel panelRightBottom = new JPanel();
//    JPanel panelTextInput = new JPanel();


    panelTop.setPreferredSize(new Dimension(500,300));
    panelMain.setPreferredSize(new Dimension(500,300));
    panelRightTop.setPreferredSize(new Dimension(500,300));
    panelRightMiddle.setPreferredSize(new Dimension(500,300));
    panelRightBottom.setPreferredSize(new Dimension(500,300));
//    panelTextInput.setPreferredSize(new Dimension(500,300));


    panelBg.setBounds(0, 0, 800, 600);

    panelTop.setBounds(0, 0, 800, 50);
    panelMain.setBounds(0, 50, 500, 500);
    panelRightTop.setBounds(500, 50, 300, 200);
    panelRightMiddle.setBounds(500, 250, 300, 150);
    panelRightBottom.setBounds(500, 400, 300, 150);
//    panelTextInput.setBounds(0, 500, 500, 50);

    panelTop.setBorder(new EmptyBorder(5,0,0,0));

//    panelTextInput.setBackground(new Color(0x6225B0C7, true));
    panelTop.setBackground(new Color(0x657E9D));
//    panelRightTop.setBackground(new Color(0x9A6F9A));
    panelRightMiddle.setBackground(new Color(0xD6C5EE));
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
        +"<h3>CLICK START BUTTON ON TOP OF THE SCREEN.<h3><br>"

        + "</html>");

    gameDescriptionLabel.setHorizontalAlignment(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of imageicon
    gameDescriptionLabel.setVerticalAlignment(JLabel.TOP); // set text TOP, CENTER, BOTTOM of imageicon
    gameDescriptionLabel.setForeground(new Color(0, 0, 0, 255));
    gameDescriptionLabel.setFont(new Font("Comic Sans", Font.PLAIN, 13));


    JButton gameStartButton = new JButton();
    gameStartButton.setText("START");
    gameStartButton.setFocusable(false);
    gameStartButton.setHorizontalAlignment(JButton.CENTER);
    gameStartButton.setVerticalAlignment(JButton.CENTER);
    gameStartButton.setFont(new Font("Comic Sans", Font.BOLD, 10));
    gameStartButton.setIconTextGap(5);
    gameStartButton.setForeground(Color.WHITE);
    gameStartButton.setBorder(BorderFactory.createEmptyBorder());
    gameStartButton.setBackground(new Color(0xAD619B56));
    gameStartButton.setBorder(BorderFactory.createEtchedBorder());
    gameStartButton.setPreferredSize(new Dimension(100,30));

    JLabel introImageLabel = new JLabel();

//    try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("spaceman2.jpg")) {
//      byte[] buffer = inputStream.readAllBytes();
//      Icon introImage = new ImageIcon(buffer);
//      introImageLabel.setIcon(introImage);
//    }

    Icon introImage1 = new ImageIcon("src/main/resources/bg11.jpg");
    introImageLabel.setIcon(introImage1);


    gameStartButton.addActionListener(e -> {
      gameStartButton.setEnabled(false);
      panelMain.removeAll();
      panelMain.repaint();
      panelMain.add(introImageLabel);
    });



    panelMain.add(gameDescriptionLabel);


    panelRightBottom.setLayout(new BorderLayout());

    JButton directionWest = new JButton();
    directionWest.setText("WEST");
    directionWest.setFocusable(false);
    directionWest.setHorizontalAlignment(JButton.CENTER);
    directionWest.setVerticalAlignment(JButton.CENTER);
    directionWest.setFont(new Font("Comic Sans", Font.BOLD, 10));
    directionWest.setIconTextGap(5);
    directionWest.setForeground(Color.WHITE);
    directionWest.setBorder(BorderFactory.createEmptyBorder());
    directionWest.setBackground(new Color(0x5B90E5));
    directionWest.setBorder(BorderFactory.createEtchedBorder());
    directionWest.setPreferredSize(new Dimension(50,15));

    JButton directionEast = new JButton();
    directionEast.setText("EAST");
    directionEast.setFocusable(false);
    directionEast.setHorizontalAlignment(JButton.CENTER);
    directionEast.setVerticalAlignment(JButton.CENTER);
    directionEast.setFont(new Font("Comic Sans", Font.BOLD, 10));
    directionEast.setIconTextGap(5);
    directionEast.setForeground(Color.WHITE);
    directionEast.setBorder(BorderFactory.createEmptyBorder());
    directionEast.setBackground(new Color(0x5B90E5));
    directionEast.setBorder(BorderFactory.createEtchedBorder());
    directionEast.setPreferredSize(new Dimension(50,15));

    JButton directionNorth = new JButton();
    directionNorth.setText("NORTH");
    directionNorth.setFocusable(false);
    directionNorth.setHorizontalAlignment(JButton.CENTER);
    directionNorth.setVerticalAlignment(JButton.CENTER);
    directionNorth.setFont(new Font("Comic Sans", Font.BOLD, 10));
    directionNorth.setIconTextGap(5);
    directionNorth.setForeground(Color.WHITE);
    directionNorth.setBorder(BorderFactory.createEmptyBorder());
    directionNorth.setBackground(new Color(0x5B90E5));
    directionNorth.setBorder(BorderFactory.createEtchedBorder());
    directionNorth.setPreferredSize(new Dimension(50,30));

    JButton directionSouth = new JButton();
    directionSouth.setText("SOUTH");
    directionSouth.setFocusable(false);
    directionSouth.setHorizontalAlignment(JButton.CENTER);
    directionSouth.setVerticalAlignment(JButton.CENTER);
    directionSouth.setFont(new Font("Comic Sans", Font.BOLD, 10));
    directionSouth.setIconTextGap(5);
    directionSouth.setForeground(Color.WHITE);
    directionSouth.setBorder(BorderFactory.createEmptyBorder());
    directionSouth.setBackground(new Color(0x5B90E5));
    directionSouth.setBorder(BorderFactory.createEtchedBorder());
    directionSouth.setPreferredSize(new Dimension(50,30));

    JPanel buttonUpandDownPanel = new JPanel();
    buttonUpandDownPanel.setLayout(new GridLayout(2,0));
    JButton directionButtonUp = new JButton("UP");
    JButton directionButtonDown = new JButton("DOWN");
    directionButtonUp.setBorder(BorderFactory.createEtchedBorder());
    directionButtonDown.setBorder(BorderFactory.createEtchedBorder());
    directionButtonUp.setBackground(new Color(0x3EB62C));
    directionButtonDown.setBackground(new Color(0x3EB52D));
    directionButtonUp.setFocusable(false);
    directionButtonDown.setFocusable(false);
    buttonUpandDownPanel.add(directionButtonUp);
    buttonUpandDownPanel.add(directionButtonDown);


    panelRightBottom.add(directionWest, BorderLayout.WEST);
    panelRightBottom.add(directionEast, BorderLayout.EAST);
    panelRightBottom.add(directionNorth, BorderLayout.NORTH);
    panelRightBottom.add(directionSouth, BorderLayout.SOUTH);
    panelRightBottom.add(buttonUpandDownPanel, BorderLayout.CENTER);


    JTextArea inventoryTextArea = new JTextArea(10,27);
    inventoryTextArea.append("- Current Location: DATA FROM JSON\n" );
    inventoryTextArea.append("- Available Exits: east: DATA FROM JSON\n");
    inventoryTextArea.append("- Items in current location: DATA FROM JSON\n");
    inventoryTextArea.append("- Characters in current location: DATA FROM JSON\n");
    inventoryTextArea.append("- Monster in current location: DATA FROM JSON\n");
    inventoryTextArea.append("- Currently equipped item: DATA FROM JSON\n");

    inventoryTextArea.setLineWrap(true);

//    panelRightTop.add(inventoryTextArea);

    panelTop.add(gameStartButton);
    panelTop.add(buttonHelp);
    panelTop.add(buttonSetting);
    panelTop.add(buttonQuit);
    panelTop.add(buttonMap);
    panelTop.add(timerLabel);



    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setBounds(0,0,800,600);

    layeredPane.add(panelBg,Integer.valueOf(0));
    layeredPane.add(panelTop,Integer.valueOf(3));
    layeredPane.add(panelMain,Integer.valueOf(4));
    layeredPane.add(panelRightTop,Integer.valueOf(1));
    layeredPane.add(panelRightMiddle,Integer.valueOf(7));
    layeredPane.add(panelRightBottom,Integer.valueOf(5));
//    layeredPane.add(panelTextInput,Integer.valueOf(2));

//
//    panelRight.setLayout(new BorderLayout());
//    panelRight.add(panelRightTop, BorderLayout.NORTH);
//    panelRight.add(panelRightMiddle, BorderLayout.CENTER);
//    panelRight.add(panelRightBottom, BorderLayout.SOUTH);
//


//
//
//    this.setLayout(new BorderLayout());
//    this.add(panelTop, BorderLayout.NORTH);
//    this.add(panelMain, BorderLayout.CENTER);
//    this.add(panelRight, BorderLayout.EAST);




    this.add(layeredPane);
    this.setVisible(true);

  }
}
