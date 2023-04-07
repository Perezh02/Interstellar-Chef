package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Powder extends Entity {

    public Powder(GamePanel gp) {
        super(gp);

        name = Main.objects[19].getName();
        description = name + Main.objects[19].getDescription();
        down1 = setup("/object/powder", gp.tileSize, gp.tileSize);
    }
}
