package com.interstellarchef.controller;

import static com.interstellarchef.view.View.clearScreen;
import com.google.gson.Gson;
import com.interstellarchef.model.Character;
import com.interstellarchef.model.Game;
import com.interstellarchef.model.GameText;
import com.interstellarchef.model.Item;
import com.interstellarchef.model.Location;
import com.interstellarchef.view.View;

import java.io.InputStreamReader;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class GameController {

  Game game;
  GameText gameText;

 public GameController(){
   setUpGameText();
   runGameIntro();
   startGame();
 }

  public void startGame(){
    //clearScreen();
    System.out.println(gameText.getNewGameMessage());
    String input;
    Scanner scan = new Scanner(System.in);
    input = scan.nextLine().toLowerCase();
    if(input.equals(gameText.getAffirmative())){
      playGame();
    }else{
      quitGame(false);
    }

  }

  public void quitGame(boolean ask) {
    String quitGame;
    if (ask) {
      System.out.println(gameText.getConfirmQuitMessage());
      quitGame = getUserInput();
    } else {
      quitGame = "yes";
    }
      if (quitGame.equals(gameText.getAffirmative())) {
        System.out.println(gameText.getGoodbyeMessage());
        System.exit(0);
      } else {
        System.out.println("It's our honor you choose to stay with us");
      }
  }

  public String getUserInput(){
    String input;
    Scanner scan = new Scanner(System.in);
    input = scan.nextLine().toLowerCase();
    if(input.equals(gameText.getQuitKeyWord())){
      quitGame(true);
    }
    return input;
  }

  public void runGameIntro(){

    View viewInstance = new View(gameText);
    viewInstance.printStartBanner();

    String input = getUserInput();
    while(!input.equals("")){
      viewInstance.printStartBanner();
      input = getUserInput();
    }

    viewInstance.printGameIntro();
  }

  public void playGame(){

    //todo: set up files from json, and set this.game

    TextParser parser = new TextParser(this);
    while(true){
        clearScreen();
        parser.promptUserAction();
        String input = getUserInput();
        while(!input.equals("")){
          input = getUserInput();
        }
    }


  }

  public void setUpGameText(){
    Gson gson = new Gson();

    try (Reader reader = new InputStreamReader(getClass()
                    .getClassLoader()
                    .getResourceAsStream("gametext.json"))) {

      this.gameText = gson.fromJson(reader,GameText.class);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public GameText getGameText() {
    return gameText;
  }

  public void setGameText(GameText gameText) {
    this.gameText = gameText;
  }
}
