package com.interstellarchef.model;

import java.util.HashMap;

public class Item {

  private String name;
  private String description;
  private HashMap<String,String> actionResponse; //action, text printed in response to action

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
}
