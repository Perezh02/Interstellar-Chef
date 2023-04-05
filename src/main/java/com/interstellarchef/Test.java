package com.interstellarchef;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Test {

  public void test(){


    JLabel label1 = new JLabel();
    label1.setOpaque(true);
    label1.setBackground(Color.RED);
    // adding it from 0,0 coordination.
    label1.setBounds(0,0,200,200);

//    label1.setIcon(new ImageIcon("src/main/resources/intro.gif"));

    JLabel label2 = new JLabel();
    label2.setOpaque(true);
    label2.setBackground(Color.GREEN);
    label2.setText("Green background label2 test");
    label2.setBounds(0,20,300,200);

    JLabel label3 = new JLabel();
    label3.setOpaque(true);
    label3.setBackground(Color.BLUE);
    label2.setText("Blue background label3 test");
    label3.setBounds(150,150,200,200);


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

    JLabel bgLabel = new JLabel();
    bgLabel.setIcon(new ImageIcon("src/main/resources/intro.gif"));

    JPanel backgroundPanel = new JPanel();
    backgroundPanel.setBounds(0, 0, 500, 500);
    backgroundPanel.add(bgLabel);




    JPanel panel1 = new JPanel();

//    Button button1 = new Button("button");
//    button1.setBounds(0,0,100,50);
//    panel1.add(button1);
    panel1.add(label1);


//



    JLayeredPane layeredPane = new JLayeredPane();

//    layeredPane.add(panelTop, BorderLayout.NORTH);
//    layeredPane.add(panelCenter, BorderLayout.CENTER);

    layeredPane.setBounds(0,0,800,600);

    layeredPane.add(panel1,Integer.valueOf(3));
    layeredPane.add(label2,Integer.valueOf(2));
    layeredPane.add(label3,Integer.valueOf(1));
    layeredPane.add(backgroundPanel,Integer.valueOf(0));



    JFrame frame = new JFrame("JLayeredPane");
    frame.add(layeredPane);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(new Dimension(800,600));
//    frame.setLayout(null);
    frame.setVisible(true);
  }

}
