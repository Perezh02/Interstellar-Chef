package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Pepper extends Entity {

    public Pepper(GamePanel gp) {
        super(gp);

        name = Main.objects[24].getName();
        description = name + Main.objects[24].getDescription();
        down1 = setup("/object/pepper", gp.tileSize, gp.tileSize);
    }
}