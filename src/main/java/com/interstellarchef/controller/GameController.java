package com.interstellarchef.controller;

import static com.interstellarchef.view.View.clearScreen;
import com.interstellarchef.view.View;
import java.util.Locale;
import java.util.Scanner;

public class GameController {

 public GameController(){
   runGameIntro();
   startGame();
 }

  public void startGame(){
    clearScreen();
    System.out.println("Would you like to start a new game? Yes or no");
    String input;
    Scanner scan = new Scanner(System.in);
    input = scan.nextLine().toLowerCase();
    if(input.equals("yes")){
      playGame();
    }else{
      quitGame();
    }

  }

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

  public void runGameIntro(){

    View viewInstance = new View();
    viewInstance.printStartBanner();

    String input = getUserInput();
    while(!input.equals("")){
      viewInstance.printStartBanner();
      input = getUserInput();
    }

    viewInstance.printGameIntro();
  }

  public void playGame(){

    System.out.println("The game start! Enjoy!");
  }

}
