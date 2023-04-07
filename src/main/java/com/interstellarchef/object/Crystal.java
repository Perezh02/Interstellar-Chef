package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Crystal extends Entity {

    public Crystal(GamePanel gp) {
        super(gp);

        name = Main.objects[14].getName();
        description = name + Main.objects[14].getDescription();
        down1 = setup("/object/snowflake", gp.tileSize, gp.tileSize);
    }
}
