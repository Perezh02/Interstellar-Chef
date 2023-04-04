package com.interstellarchef.tile;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.interstellarchef.gui.GamePanel;
import com.interstellarchef.gui.UtilityTool;
import com.interstellarchef.location.Location;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.imageio.ImageIO;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;
    public int[][] locationNum;
    public int[][] locationMap;
    ArrayList<String> fileNames = new ArrayList<>();
    ArrayList<String> collisionStatus =new ArrayList<>();
    public Map<Integer, String> areaNames;

    public TileManager(GamePanel gp) {

        this.gp = gp;

        InputStream is = getClass().getResourceAsStream("/maps/tiledata.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line;

        try {
            while ((line = br.readLine()) != null) {
                fileNames.add(line);
                collisionStatus.add(br.readLine());
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tile = new Tile[fileNames.size()];
        getTileImage();

        is = getClass().getResourceAsStream("/maps/map.txt");
        br = new BufferedReader(new InputStreamReader(is));

        try {
            String line2 = br.readLine();
            String[] maxTile = line2.split(" ");

            gp.maxWorldCol = maxTile.length;
            gp.maxWorldRow = maxTile.length;
            mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
            locationMap = new int[gp.maxWorldCol][gp.maxWorldRow];

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        loadMap("/maps/map.txt");
        areaNames = loadAreaNames("/maps/location.json");

        assignLocation(34, 56, 11, 10, 1);
        assignLocation(46, 57, 8, 11, 2);
        assignLocation(55, 57, 7, 8, 3);
        assignLocation(46, 69, 8, 13, 4);
        assignLocation(34, 70, 11, 10, 5);
        assignLocation(57, 70, 11, 10, 6);
        assignLocation(44, 83, 13, 15, 7);
        assignLocation(45, 45, 11, 11, 8);
        assignLocation(56, 46, 11, 10, 9);
        assignLocation(46, 34, 9, 10, 10);
        assignLocation(36, 35, 11, 10, 11);
        assignLocation(56, 35, 11, 10, 12);
        assignLocation(39, 26, 6, 6, 13);
        assignLocation(55, 26, 6, 6, 14);
        assignLocation(46, 22, 8, 11, 15);
        assignLocation(42, 9, 16, 12, 16);

        assignLocation(4, 5, 16, 10, 17);
        assignLocation(3, 83, 18, 13, 18);
        assignLocation(77, 7, 18, 18, 19);
        assignLocation(77, 83, 19, 14, 20);

    }

    private Map<Integer, String> loadAreaNames(String fileName) {
        Map<Integer, String> names = new HashMap<>();
        try {
            InputStream is = getClass().getResourceAsStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder jsonText = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonText.append(line);
            }
            br.close();

            Gson gson = new Gson();
            Type listType = new TypeToken<List<Location>>() {}.getType();
            List<Location> areas = gson.fromJson(jsonText.toString(), listType);
            for (Location area : areas) {
                names.put(area.getArea(), area.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }

    public void assignLocation(int startX, int startY, int areaWidth, int areaHeight, int locationNumber) {
        for (int x = startX; x < startX + areaWidth; x++) {
            for (int y = startY; y < startY + areaHeight; y++) {
                locationMap[x][y] = locationNumber;
            }
        }
    }

    public String getLocationName(int locationNum) {
        String location = areaNames.get(locationNum);
        if (location != null) {
            location = areaNames.get(locationNum);
        } else {
            location = "";
        }
        return location;
    }





    public void getTileImage() {

        for (int i = 0; i < fileNames.size(); i++) {
            String fileName;
            boolean collision;

            fileName = fileNames.get(i);

            if (collisionStatus.get(i).equals("true")) {
                collision = true;
            }
            else {
                collision = false;
            }

            setup(i, fileName, collision);
        }
    }

    public void setup(int index, String imagePath, boolean collision) {
        UtilityTool uTool = new UtilityTool();

        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(
                Objects.requireNonNull(getClass().getResourceAsStream("/tiles/" + imagePath)));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

                String line = br.readLine();

                while (col < gp.maxWorldCol) {

                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {

        }
    }

    public void assignLocationNumbers() {
        // example of how you can assign location numbers based on mapTileNum array
        for (int col = 0; col < gp.maxWorldCol; col++) {
            for (int row = 0; row < gp.maxWorldRow; row++) {
                int tileNum = mapTileNum[col][row];
                if (tileNum == 1) {
                    locationNum[col][row] = 1; // assign location number 1 to tiles with tileNum = 1
                } else if (tileNum == 2) {
                    locationNum[col][row] = 2; // assign location number 2 to tiles with tileNum = 2
                } else {
                    locationNum[col][row] = 0; // assign location number 0 to other tiles
                }
            }
        }
    }

    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;


        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }

            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}