package com.interstellarchef.object;

public class Object {

    public String name;
    public String description;

    public Object(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
