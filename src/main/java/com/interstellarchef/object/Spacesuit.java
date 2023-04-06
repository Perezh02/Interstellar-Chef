package com.interstellarchef.object;


import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Spacesuit extends Entity {

    public Spacesuit(GamePanel gp) {
        super(gp);

        type = typeSpacesuitEquipped;
        name = "Spacesuit";
        description = name + "\n A white spacesuit.";
        down1 = setup("/player/spaceman_white_down_1", gp.tileSize, gp.tileSize);
    }
}

