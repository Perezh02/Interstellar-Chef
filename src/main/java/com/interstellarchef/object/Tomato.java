package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Tomato extends Entity {

    public Tomato(GamePanel gp) {
        super(gp);

        name = Main.objects[21].getName();
        description = name + Main.objects[21].getDescription();
        down1 = setup("/object/tomato", gp.tileSize, gp.tileSize);
    }
}
