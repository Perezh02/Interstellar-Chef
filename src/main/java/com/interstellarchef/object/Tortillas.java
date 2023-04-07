package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Tortillas extends Entity {

    public Tortillas(GamePanel gp) {
        super(gp);

        name = Main.objects[4].getName();
        description = name + Main.objects[4].getDescription();
        down1 = setup("/object/tortilla", gp.tileSize, gp.tileSize);
    }
}
