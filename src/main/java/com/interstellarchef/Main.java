package com.interstellarchef;

import com.google.gson.Gson;
import com.interstellarchef.entity.NPC;
import com.interstellarchef.gui.GamePanel;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.swing.JFrame;

public class Main {

    public static Object[] objects;
    public static NPC[] npcs;

    public static void main(String[] args) {

        Gson gson = new Gson();
        objects = new Object[4];
        npcs = new NPC[1];

        try (Reader reader = new InputStreamReader(Main.class.getClassLoader().getResourceAsStream(
            "objects.json"))) {
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

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Interstellar Chef");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
    }

}

