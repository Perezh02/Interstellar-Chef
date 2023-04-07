package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Salsa extends Entity {

    public Salsa(GamePanel gp) {
        super(gp);

        name = Main.objects[22].getName();
        description = name + Main.objects[22].getDescription();
        down1 = setup("/object/salsa", gp.tileSize, gp.tileSize);
    }
}