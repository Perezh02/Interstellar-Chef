package com.interstellarchef;

import com.google.gson.Gson;
import com.interstellarchef.entity.NPC;
import com.interstellarchef.gui.GamePanel;
import com.interstellarchef.util.MusicPlayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;



public class GameFrame extends JFrame{

  JLabel label1;
  JButton button;
  MusicPlayer musicPlayer = new MusicPlayer();
  GamePanel gamePanel = new GamePanel();

  JButton buttonMap;
  JLabel timerLabel;
  private int timerSeconds;

  public static Object[] objects;
  public static NPC[] npcs;



  public GameFrame() throws IOException {
    this.setTitle("Interstellar Chef");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setSize(800,600);


    button = new JButton();

//    musicPlayer.play();


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

    this.setLayout(new BorderLayout(0, 0));
    JPanel panelTop = new JPanel();
    JPanel panelCenter = new JPanel();
    this.add(panelTop, BorderLayout.NORTH);
    this.add(panelCenter, BorderLayout.CENTER);
    this.setSize(600, 600);
    panelTop.setPreferredSize(new Dimension(500,150));
    panelCenter.setPreferredSize(new Dimension(500,450));
    panelCenter.setBackground(new Color(0x18263E));
    panelTop.setBackground(new Color(0xBDDAE9FF, true));

    JButton buttonQuit = new JButton();
    buttonQuit.setText("QUIT");
    buttonQuit.setFocusable(false);
    buttonQuit.setHorizontalAlignment(JButton.CENTER);
    buttonQuit.setVerticalAlignment(JButton.CENTER);
    buttonQuit.setFont(new Font("Comic Sans", Font.BOLD, 10));
    buttonQuit.setIconTextGap(5);
    buttonQuit.setForeground(Color.BLACK);
    buttonQuit.setBorder(BorderFactory.createEmptyBorder());
    buttonQuit.setBackground(new Color(0xB45D5D));
    buttonQuit.setBorder(BorderFactory.createEtchedBorder());
    buttonQuit.setPreferredSize(new Dimension(100, 60));

    JButton buttonHelp = new JButton();
    buttonHelp.setText("HELP");
    buttonHelp.setFocusable(false);
    buttonHelp.setHorizontalAlignment(JButton.CENTER);
    buttonHelp.setVerticalAlignment(JButton.CENTER);
    buttonHelp.setFont(new Font("Comic Sans", Font.BOLD, 10));
    buttonHelp.setIconTextGap(5);
    buttonHelp.setForeground(Color.BLACK);
    buttonHelp.setBorder(BorderFactory.createEmptyBorder());
    buttonHelp.setBackground(new Color(0x5B90E5));
    buttonHelp.setBorder(BorderFactory.createEtchedBorder());
    buttonHelp.setPreferredSize(new Dimension(100, 60));

    JButton buttonSetting = new JButton();
    buttonSetting.setText("SETTINGS");
    buttonSetting.setFocusable(false);
    buttonSetting.setHorizontalAlignment(JButton.CENTER);
    buttonSetting.setVerticalAlignment(JButton.CENTER);
    buttonSetting.setFont(new Font("Comic Sans", Font.BOLD, 10));
    buttonSetting.setIconTextGap(5);
    buttonSetting.setForeground(Color.BLACK);
    buttonSetting.setBorder(BorderFactory.createEmptyBorder());
    buttonSetting.setBackground(new Color(0x5B90E5));
    buttonSetting.setBorder(BorderFactory.createEtchedBorder());
    buttonSetting.setPreferredSize(new Dimension(100, 60));

    JButton buttonMap = new JButton();
    buttonMap.setText("MAP");
    buttonMap.setFocusable(false);
    buttonMap.setHorizontalAlignment(JButton.CENTER);
    buttonMap.setVerticalAlignment(JButton.CENTER);
    buttonMap.setFont(new Font("Comic Sans", Font.BOLD, 10));
    buttonMap.setIconTextGap(5);
    buttonMap.setForeground(Color.BLACK);
    buttonMap.setBorder(BorderFactory.createEmptyBorder());
    buttonMap.setBackground(new Color(0x5B90E5));
    buttonMap.setBorder(BorderFactory.createEtchedBorder());
    buttonMap.setPreferredSize(new Dimension(100, 60));




    // create the timer label with the custom font and color
    JLabel timerLabel = new JLabel("00:00");
    timerLabel.setFont(new Font("Arial", Font.BOLD, 20));
    timerLabel.setForeground(new Color(0x380E4A));

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
    buttonMap.addActionListener(e -> new MapDialog(this).mapPopUp());
    buttonQuit.addActionListener(e -> System.exit(0));


    JLabel gameDescriptionLabel = new JLabel();
    gameDescriptionLabel.setText("<html>"
        + "<h2><u><center>Hello Culinary Cosmonauts!</center></u></h2> <br>"
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
        +"<h3><center>CLICK HELP BUTTON FOR KEY INSTRUCTIONS PRIOR TO START</center><h3><br><br>"
        + "</html>");

    gameDescriptionLabel.setHorizontalAlignment(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of imageicon
    gameDescriptionLabel.setVerticalAlignment(JLabel.TOP); // set text TOP, CENTER, BOTTOM of imageicon
    gameDescriptionLabel.setForeground(new Color(255, 255, 255, 255));
    gameDescriptionLabel.setFont(new Font("Comic Sans", Font.PLAIN, 15));

    JButton gameStartButton = new JButton();
    gameStartButton.setText("START");
    gameStartButton.setFocusable(false);
    gameStartButton.setHorizontalAlignment(JButton.CENTER);
    gameStartButton.setVerticalAlignment(JButton.CENTER);
    gameStartButton.setFont(new Font("Comic Sans", Font.BOLD, 10));
    gameStartButton.setIconTextGap(5);
    gameStartButton.setForeground(Color.BLACK);
    gameStartButton.setBorder(BorderFactory.createEmptyBorder());
    gameStartButton.setBackground(new Color(0xAD619B56));
    gameStartButton.setBorder(BorderFactory.createEtchedBorder());
    gameStartButton.setPreferredSize(new Dimension(100,60));

    JLabel introImageLabel = new JLabel();


    gameStartButton.addActionListener(e -> {
      this.setSize(400,600);

      gameStartButton.setEnabled(false);
      Gson gson = new Gson();
      objects = new Object[4];
      npcs = new NPC[1];
        try (Reader reader = new InputStreamReader(
            Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream(
                "objects.json")))) {
            objects = gson.fromJson(reader, Object[].class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (Reader reader = new InputStreamReader(
            Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream(
                "npc.json")))) {
            npcs = gson.fromJson(reader, NPC[].class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


//      GamePanel gamePanel = new GamePanel();

      JFrame window = new JFrame();
      window.setSize(new Dimension(800, 600));
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setResizable(false);
      window.setTitle("Interstellar Chef");
      window.add(gamePanel);
      window.pack();
      window.setVisible(true);
      gamePanel.setupGame();
      gamePanel.startGameThread();
      window.setLocationRelativeTo(null); // center the frame on the screen
      window.setLocation(GameFrame.this.getX() + GameFrame.this.getWidth(), GameFrame.this.getY()); // set location to the right of the main frame

      try(InputStream imageStream = getClass().getClassLoader().getResourceAsStream("spaceship.png")) {
        assert imageStream != null;
        BufferedImage buffer = ImageIO.read(imageStream);
        window.setIconImage(buffer);
      } catch (IOException ioException) {
        ioException.printStackTrace();
      }

      Icon introImage1 = new ImageIcon("src/main/resources/spaceships2.gif");
      introImageLabel.setIcon(introImage1);
      panelCenter.removeAll();
      panelCenter.repaint();
      panelCenter.add(introImageLabel);
      panelTop.add(timerLabel);
    });


    panelTop.setBorder(new EmptyBorder(10,0,0,0));
    panelTop.add(gameStartButton);
    panelTop.add(buttonHelp);
    panelTop.add(buttonSetting);
    panelTop.add(buttonMap);
    panelTop.add(buttonQuit);
    panelCenter.add(gameDescriptionLabel);

    this.setVisible(true);

  }

  public JButton getButtonMap() {
    return buttonMap;
  }

  public void setButtonMap(JButton buttonMap) {
    this.buttonMap = buttonMap;
  }
}
