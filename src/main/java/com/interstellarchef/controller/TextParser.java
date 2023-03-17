package com.interstellarchef.controller;

import com.interstellarchef.model.Character;
import com.interstellarchef.model.Game;
import com.interstellarchef.model.Item;

public class TextParser {

  //todo: when JSON files created, take values and printed strings below from the JSON file
  private final GameController gameController;
  private final Game game;

  TextParser(GameController gameController, Game game){
    this.gameController = gameController;
    this.game = game;
  }


  public void promptUserAction(){
    boolean valid = false;
    String currentAction;
    String currentNoun;

    while(!valid){
      System.out.println("What would you like to do?"); //todo: load from json
      String input = gameController.getUserInput();
      String[] inputArray = input.split(" ", 2);
      currentAction = inputArray[0];

      //check if input greater than 1 word, else continue
      if(inputArray.length == 1) {
          if (inputArray[0].equalsIgnoreCase("help")) {
              String helpInfo = "*********************************************** HELP ***********************************************\n" +
                      "\t\tDirection options: North, South, West, East, Up & Down\n" +
                      "\t\tgo/walk/run/climb <Direction>: Moves character in selected direction\n" +
                      "\t\tget/grab/take <Item Name>: Adds item to Player's Inventory\n" +
                      "\t\tlook/inspect/examine <Item Name>: Investigates Item\n" +
                      "\t\tuse/utilize/apply <Item Name>: item disappears from your inventory once you use it\n" +
                      "\t\thelp: Displays a list of valid commands\n" +
                      "\t\tquit: ends the game\n" +
                      "****************************************************************************************************\n";
              System.out.println(helpInfo);
          } else {
              System.out.println("Looks like you forgot a word! Please try again."); //todo: load from json
          }
          continue;
      }

      //check noun and action
      currentNoun = checkInput(currentAction, inputArray[1]);

      //if noun not valid, continue
      if(currentNoun.equals("")) {
        System.out.println("You can't do that! Try again."); //todo: load from json
      } else {
        valid = true;
      }
    }

  }

  private String checkInput(String action, String noun){
    String result = "";

    //check directions
    if (action.equalsIgnoreCase("go")){ //todo: include synonyms and load from json
      for (String direction : game.getCurrentLocation().getExits().keySet()){
        if(noun.equalsIgnoreCase(direction)){
          //change current location
          game.changeCurrentLocation(direction);
          return direction;
        }
      }
    }

    //check characters
    if (action.equalsIgnoreCase("talk") || action.equalsIgnoreCase("look")) { //todo: include synonyms and load from json
      for(Character character: game.getCurrentLocation().getCharacters()){
        if(noun.equalsIgnoreCase(character.getName())){
          return character.getName();
        }
      }
    }

    //check items in current room
    if (action.equalsIgnoreCase("grab") || action.equalsIgnoreCase("look")) {//todo: include synonyms and load from json
      for(Item item: game.getCurrentLocation().getItems()){
        if(noun.equalsIgnoreCase(item.getName())){
          for (String allowedAction : item.getActionResponse().keySet()) {
            //checks if action can be performed on item
            if (action.equalsIgnoreCase(allowedAction)){
              return item.getName();
            }
          }
        }
      }
    }

    //check items in inventory
    for(Item item: game.getInventory().getItems()){
      if(noun.equalsIgnoreCase(item.getName())){
        for (String allowedAction : item.getActionResponse().keySet()) {
          //checks if action can be performed on item
          if (action.equalsIgnoreCase(allowedAction)){
            result = item.getName();
            break;
          }
          break;
        }
      }
    }

    return result;
  }



}
