package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Meatball extends Entity {

    public Meatball(GamePanel gp) {
        super(gp);

        name = Main.objects[12].getName();
        description = name + Main.objects[12].getDescription();
        down1 = setup("/object/meatball", gp.tileSize, gp.tileSize);
    }
}