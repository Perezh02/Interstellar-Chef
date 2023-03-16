package com.interstellarchef.model;

import java.util.HashMap;
import java.util.List;

public class Location {

  private String name;
  private String description;
  private HashMap<String, String> exits; //direction, exit to
  private List<Item> items;
  private Character[] characters;

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

  public HashMap<String, String> getExits() {
    return exits;
  }

  public void setExits(HashMap<String, String> exits) {
    this.exits = exits;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public Character[] getCharacters() {
    return characters;
  }

  public void setCharacters(Character[] characters) {
    this.characters = characters;
  }
}
