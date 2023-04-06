package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Milk extends Entity {

    public Milk(GamePanel gp) {
        super(gp);

        name = Main.objects[2].getName();
        description = name + Main.objects[2].getDescription();
        down1 = setup("/object/milk", gp.tileSize, gp.tileSize);
    }
}