package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Butter extends Entity {

    public Butter(GamePanel gp) {
        super(gp);

        name = Main.objects[3].getName();
        description = name + Main.objects[3].getDescription();
        down1 = setup("/object/butter", gp.tileSize, gp.tileSize);
    }
}
