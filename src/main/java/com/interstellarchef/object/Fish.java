package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Fish extends Entity {

    public Fish(GamePanel gp) {
        super(gp);

        name = Main.objects[16].getName();
        description = name + Main.objects[16].getDescription();
        down1 = setup("/object/fish", gp.tileSize, gp.tileSize);
    }
}
