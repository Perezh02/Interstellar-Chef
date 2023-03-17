package com.interstellarchef.model;

import java.util.List;

public class Game {
  Location currentLocation;
  Location inventory;
  Item currentRecipe;
  List<String> completedRecipes;

  public Game(Location currentLocation, Location inventory) {
    this.currentLocation = currentLocation;
    this.inventory = inventory;
    this.currentRecipe = currentRecipe;
    this.completedRecipes = completedRecipes;
  }

  public Location getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(Location currentLocation) {
    this.currentLocation = currentLocation;
  }

  public Location getInventory() {
    return inventory;
  }

  public void setInventory(Location inventory) {
    this.inventory = inventory;
  }

  public Item getCurrentRecipe() {
    return currentRecipe;
  }

  public void setCurrentRecipe(Item currentRecipe) {
    this.currentRecipe = currentRecipe;
  }

  public List<String> getCompletedRecipes() {
    return completedRecipes;
  }

  public void setCompletedRecipes(List<String> completedRecipes) {
    this.completedRecipes = completedRecipes;
  }
}
