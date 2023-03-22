package com.interstellarchef.model;

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

  public void giveItem(Player player){
    if(items.size() >= 1){
      System.out.println(name + ": Take this.");
      System.out.println("You received " + items.get(0).getName());
      player.getInventory().addItem(items.get(0));
      System.out.println(items.get(0).getActionResponse().get("get"));
      items.remove(0);

    }
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
