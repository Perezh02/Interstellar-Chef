package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Snacks extends Entity {

    public Snacks(GamePanel gp) {
        super(gp);

        name = Main.objects[5].getName();
        description = name + Main.objects[5].getDescription();
        down1 = setup("/object/snack", gp.tileSize, gp.tileSize);
    }
}
