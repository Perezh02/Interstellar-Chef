package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Key extends Entity {

    public Key(GamePanel gp) {
        super(gp);

        name = Main.objects[9].getName();
        description = name + Main.objects[9].getDescription();
        down1 = setup("/object/key", gp.tileSize, gp.tileSize);
    }
}

