package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class GPS extends Entity {

    public GPS(GamePanel gp) {
        super(gp);

        name = Main.objects[7].getName();
        description = name + Main.objects[7].getDescription();
        down1 = setup("/object/gps", gp.tileSize, gp.tileSize);
    }
}

