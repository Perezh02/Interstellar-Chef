package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Tofu extends Entity {

    public Tofu(GamePanel gp) {
        super(gp);

        name = Main.objects[8].getName();
        description = name + Main.objects[8].getDescription();
        down1 = setup("/object/tofu", gp.tileSize, gp.tileSize);
    }
}
