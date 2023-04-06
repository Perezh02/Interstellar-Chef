package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Rice extends Entity {

    public Rice(GamePanel gp) {
        super(gp);

        name = Main.objects[15].getName();
        description = name + Main.objects[15].getDescription();
        down1 = setup("/object/rice", gp.tileSize, gp.tileSize);
    }
}
