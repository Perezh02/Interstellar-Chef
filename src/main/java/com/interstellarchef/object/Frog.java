package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Frog extends Entity {

    public Frog(GamePanel gp) {
        super(gp);

        name = Main.objects[17].getName();
        description = name + Main.objects[17].getDescription();
        down1 = setup("/object/frog", gp.tileSize, gp.tileSize);
    }
}
