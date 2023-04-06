package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Flour extends Entity {

    public Flour(GamePanel gp) {
        super(gp);

        name = Main.objects[20].getName();
        description = name + Main.objects[20].getDescription();
        down1 = setup("/object/spice", gp.tileSize, gp.tileSize);
    }
}
