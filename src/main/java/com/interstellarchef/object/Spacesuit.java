package com.interstellarchef.object;



import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Spacesuit extends Entity {

    public Spacesuit(GamePanel gp) {
        super(gp);

        type = typeSpacesuitEquipped;
        name = Main.objects[1].getName();
        description = name + Main.objects[1].getDescription();
        down1 = setup("/player/spaceman_white_down_1", gp.tileSize, gp.tileSize);
    }
}

