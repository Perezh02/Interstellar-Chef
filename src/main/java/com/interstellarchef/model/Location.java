package com.interstellarchef.model;

import java.util.HashMap;
import java.util.List;

public class Location {

  private String name;
  private String description;
  private HashMap<String, String> exits; //direction, exit to
  private List<String> items;

}
