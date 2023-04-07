package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Rock extends Entity {

    public Rock(GamePanel gp) {
        super(gp);

        name = Main.objects[11].getName();
        description = name + Main.objects[11].getDescription();
        down1 = setup("/object/rock", gp.tileSize, gp.tileSize);
    }
}
