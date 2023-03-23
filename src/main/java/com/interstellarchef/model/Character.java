package com.interstellarchef.model;

import com.interstellarchef.controller.GameController;
import java.util.HashMap;
import java.util.List;

public class Character {
  private String name;
  private String description;
  private HashMap<String,String> actionResponse; //action, text printed in response to action
  private List<Item> items;
  private List<String> dialog;
  private String desiredItem;


  public void talk(){
    String result = "";
    System.out.println(getActionResponse().get("talk"));
    if(("Random Alien".equalsIgnoreCase(this.getName())
        || "Random Creature".equalsIgnoreCase(this.getName())
        || "Spacewalker Felix".equalsIgnoreCase(this.getName())
        || "Desert Alien".equalsIgnoreCase(this.getName())) ){
      System.out.println(String.format(dialog.get((int)(Math.random()*10)), name));
    }else{
      System.out.println(String.format(dialog.get(0), name));
    }

  }

  public boolean giveItem(Player player){
    boolean gaveItem = false;
    if(items.size() >= 1){
      System.out.println(name + ": Take this.");
      System.out.println("You received " + items.get(0).getName());
      player.getInventory().addItem(items.get(0));
      System.out.println(items.get(0).getActionResponse().get("get"));
      items.remove(0);
      gaveItem = true;
    }
    return gaveItem;
  }

  public void trade(Player player){
    Item matchedItem = null;
    if(items.size() == 0){
      return;
    } else if (desiredItem == null) {
      giveItem(player);
      dialog.remove(0);
    }
    for (Item item : player.getInventory().getItems()){
      if(item.getName().equalsIgnoreCase(desiredItem)){
        giveItem(player);
        matchedItem = item;
        break;
      }
    }
    if(matchedItem != null){
      player.getInventory().removeItem(matchedItem);
      dialog.remove(0);
    }
  }

  public void talkToChef(GameController gameController){
    System.out.println(dialog.get(0));
    boolean hasRecipe = false;
    for (Item item : gameController.getGame().getPlayer().getInventory().getItems()){
      if (item.getName().contains("Recipe")){
        hasRecipe = true;
        break;
      }
    }
    if(hasRecipe){
      //check if all ingredients in inventory

      //if they have everything, congrats and ask if they want another recipe
    } else {
      boolean gaveItem = giveItem(gameController.getGame().getPlayer());
      if(!gaveItem){
        System.out.println("You've completed all of the recipes!");
        System.out.println("Congratulations! I'm promoting you to Head Chef!");
        System.out.println("...It's time for me to retire, anyway.");
        System.out.println("You completed the entire game!");
        System.exit(0);
      }
    }

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public HashMap<String, String> getActionResponse() {
    return actionResponse;
  }

  public void setActionResponse(HashMap<String, String> actionResponse) {
    this.actionResponse = actionResponse;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }
}
