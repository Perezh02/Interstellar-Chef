package com.interstellarchef.controller;

import com.interstellarchef.model.Character;
import com.interstellarchef.model.Item;
import com.interstellarchef.model.Location;

public class TextParser {

  //todo: when JSON files created, take values and printed strings below from the JSON file
  private final GameController gameController;
  private String[] actions;
  private String[] directions;
  private Item[] items;
  private Character[] characters;

  TextParser(GameController gameController){
    this.gameController = gameController;
  }


  public void promptUserAction(){
    boolean valid = false;
    String currentAction;
    String currentNoun;
    System.out.println("What would you like to do?"); //todo: load from json

    while(!valid){
      String input = gameController.getUserInput();
      String[] inputArray = input.split(" ", 2);

      //check if input greater than 1 word, else continue
      if(inputArray.length == 1) {
        System.out.println("Looks like you forgot a word! Please try again."); //todo: load from json
        continue;
      }

      //check action
      currentAction = checkAction(inputArray[0]);

      //if action not valid, continue
      if(currentAction.equals("")) {
        System.out.println("Try again with a different action word."); //todo: load from json
        continue;
      }

      //check noun
      currentNoun = checkNoun(currentAction, inputArray[1]);

      //if noun not valid, continue
      if(currentNoun.equals("")) {
        System.out.println("You can't do that! Try again."); //todo: load from json
        //continue;
      }

    }
  }

  private String checkAction(String action){
    String result = "";
    for (String verb : actions){
      if(action.equalsIgnoreCase(verb)){
        result = verb;
        break;
      }
    }
    return result;
  }

  private String checkNoun(String action, String noun){
    String result = "";

    //check directions
    if (action.equalsIgnoreCase("go")){ //todo: include synonyms and load from json
      for (String direction : directions){
        if(noun.equalsIgnoreCase(direction)){
          return direction;
        }
      }
    }

    //check characters
    if (action.equalsIgnoreCase("talk")) { //todo: include synonyms and load from json
      for(Character character: characters){
        if(noun.equalsIgnoreCase(character.getName())){
          return character.getName();
        }
      }
    }

    //check items
    for(Item item: items){
      if(noun.equalsIgnoreCase(item.getName())){
        for (String allowedAction : item.getActionResponse().keySet()) {
          //checks if action can be performed on item
          if (action.equalsIgnoreCase(allowedAction)){
            result = item.getName();
            break;
          }
        }
        break;
      }
    }
    return result;
  }


}
