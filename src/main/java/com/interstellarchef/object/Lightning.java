package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Lightning extends Entity {

    public Lightning(GamePanel gp) {
        super(gp);

        name = Main.objects[18].getName();
        description = name + Main.objects[18].getDescription();
        down1 = setup("/object/lightning", gp.tileSize, gp.tileSize);
    }
}