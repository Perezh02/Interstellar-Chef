package com.interstellarchef.controller;

import com.interstellarchef.view.View;
import java.util.Locale;
import java.util.Scanner;

public class GameController {

  public void quitGame(){
    String quitGame;

    System.out.println("Are you sure you want to quit this game? Yes or No ");
    quitGame = getUserInput();
    if(quitGame.equals("yes")){
      System.out.println("We really don't want to say Goodbye to you");
      System.exit(0);
    }
  }

  public String getUserInput(){
    String input;
    Scanner scan = new Scanner(System.in);
    input = scan.nextLine().toLowerCase();
    if(input.equals("quit")){
      quitGame();
    }
    return input;
  }

  public void playGame(){

    View viewInstance = new View();
    viewInstance.printStartBanner();

    String input = getUserInput();
    while(!input.equals("")){
      viewInstance.printStartBanner();
      input = getUserInput();
    }

    viewInstance.printGameIntro();
  }


}
