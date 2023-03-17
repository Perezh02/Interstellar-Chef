package com.interstellarchef.controller;

import static com.interstellarchef.view.View.clearScreen;

import com.google.gson.Gson;
import com.interstellarchef.model.Character;
import com.interstellarchef.model.Game;
import com.interstellarchef.model.GameText;
import com.interstellarchef.model.Item;
import com.interstellarchef.model.Location;
import com.interstellarchef.view.View;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
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
    clearScreen();
    System.out.println(gameText.getNewGameMessage());
    String input;
    Scanner scan = new Scanner(System.in);
    input = scan.nextLine().toLowerCase();
    if(input.equals(gameText.getAffirmative())){
      playGame();
    }else{
      quitGame();
    }

  }

  public void quitGame(){
    String quitGame;

    System.out.println(gameText.getConfirmQuitMessage());
    quitGame = getUserInput();
    if(quitGame.equals(gameText.getAffirmative())){
      System.out.println(gameText.getGoodbyeMessage());
      System.exit(0);
    }
  }

  public String getUserInput(){
    String input;
    Scanner scan = new Scanner(System.in);
    input = scan.nextLine().toLowerCase();
    if(input.equals(gameText.getQuitKeyWord())){
      quitGame();
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

    //todo: The following is for testing TextParser. Replace after json functionality is completed.
    HashMap<String, String> actionResponse = new HashMap<>();
    actionResponse.put("look","a cool rock");
    Item testItem = new Item("rock","a cool rock", actionResponse);
    List<Item> itemList = new LinkedList<>();
    itemList.add(testItem);
    HashMap<String, String> exitsA = new HashMap<>();
    exitsA.put("north","kitchen");
    Location testLocationA = new Location("room", "nice room", exitsA, itemList, new Character[0]);
    HashMap<String, String> exitsB = new HashMap<>();
    exitsB.put("south","room");
    Location testLocationB = new Location("kitchen", "nice room", exitsB, itemList, new Character[0]);
    Location inventory = new Location(new String(" "), new String(" "), new HashMap<String, String>(), new LinkedList<>(), new Character[0]);
    Game game = new Game(testLocationA, inventory, new Location[]{testLocationA, testLocationB});
    TextParser parser = new TextParser(this);
    while(true){
      parser.promptUserAction();
    }


  }

  public void setUpGameText(){
    Gson gson = new Gson();

    try (Reader reader = new FileReader("src/main/resources/json/gametext.json")) {

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
