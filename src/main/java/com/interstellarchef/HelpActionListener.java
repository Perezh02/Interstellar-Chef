package com.interstellarchef;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;

public class HelpActionListener extends JDialog implements ActionListener{

//  JButton button;

  @Override
  public void actionPerformed(ActionEvent e) {
    this.dispose();
  }

}
