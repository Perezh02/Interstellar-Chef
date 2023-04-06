package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Noodles extends Entity {

    public Noodles(GamePanel gp) {
        super(gp);

        name = Main.objects[6].getName();
        description = name + Main.objects[6].getDescription();
        down1 = setup("/object/noodle", gp.tileSize, gp.tileSize);
    }
}