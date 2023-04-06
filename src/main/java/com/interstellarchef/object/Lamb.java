package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Lamb extends Entity {

    public Lamb(GamePanel gp) {
        super(gp);

        name = Main.objects[23].getName();
        description = name + Main.objects[23].getDescription();
        down1 = setup("/object/meat", gp.tileSize, gp.tileSize);
    }
}
