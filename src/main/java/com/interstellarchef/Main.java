package com.interstellarchef;

import com.google.gson.Gson;
import com.interstellarchef.entity.NPC;
import com.interstellarchef.gui.GamePanel;
import com.interstellarchef.location.Location;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;
import javax.swing.JFrame;

public class Main {

    public static Object[] objects;
    public static NPC[] npcs;

    public static void main(String[] args) throws IOException {

        GameFrame gameFrame = new GameFrame();
        gameFrame.introGUI();

        Gson gson = new Gson();
        objects = new Object[4];
        npcs = new NPC[1];

        try (Reader reader = new InputStreamReader(
            Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream(
                "objects.json")))) {
            objects = gson.fromJson(reader, Object[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Reader reader = new InputStreamReader(
            Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream(
                "npc.json")))) {
            npcs = gson.fromJson(reader, NPC[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

