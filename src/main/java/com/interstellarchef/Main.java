package com.interstellarchef;

import com.google.gson.Gson;
import com.interstellarchef.entity.NPC;
import com.interstellarchef.object.Object;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

    public static Object[] objects;
    public static NPC[] npcs;

    public static void main(String[] args) throws IOException {

        GameFrame gameFrame = new GameFrame();
        gameFrame.introGUI();

        Gson gson = new Gson();
        objects = new Object[25];
        npcs = new NPC[20];

        try (Reader reader = new InputStreamReader(Main.class.getClassLoader().getResourceAsStream(
            "items.json"))) {
            objects = gson.fromJson(reader, Object[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Reader reader = new InputStreamReader(Main.class.getClassLoader().getResourceAsStream(
            "npc.json"))) {
            npcs = gson.fromJson(reader, NPC[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

