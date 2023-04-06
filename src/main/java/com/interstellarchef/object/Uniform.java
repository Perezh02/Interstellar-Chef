package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Uniform extends Entity {

    public Uniform(GamePanel gp) {
        super(gp);

        type = typeUniformEquipped;
        name = "Uniform";
        description = name + "\n Crew Uniform";
        down1 = setup("/player/player_down_1", gp.tileSize, gp.tileSize);
    }
}
