package com.interstellarchef.location;

public class Location {

    public String name;
    public int area;

    public Location(String name, int area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public int getArea() {
        return area;
    }

}
