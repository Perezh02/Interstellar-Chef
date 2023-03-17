package com.interstellarchef.controller;

import static com.interstellarchef.view.View.clearScreen;

import com.interstellarchef.model.Character;
import com.interstellarchef.model.Game;
import com.interstellarchef.model.Item;
import com.interstellarchef.model.Location;
import com.interstellarchef.view.View;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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

    //todo: The following is for testing TextParser. Replace after json functionality is completed.
    HashMap<String, String> actionResponse = new HashMap<>();
    actionResponse.put("look","a cool rock");
    Item testItem = new Item("rock","a cool rock", actionResponse);
    List<Item> itemList = new LinkedList<>();
    itemList.add(testItem);
    HashMap<String, String> exits = new HashMap<>();
    exits.put("north","kitchen");
    Location testLocation = new Location("room", "nice room", exits, itemList, new Character[0]);
    Location inventory = new Location(new String(" "), new String(" "), new HashMap<String, String>(), new LinkedList<>(), new Character[0]);
    Game game = new Game(testLocation, inventory);
    TextParser parser = new TextParser(this, game);
    parser.promptUserAction();

  }

}
