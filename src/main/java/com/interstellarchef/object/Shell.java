package com.interstellarchef.object;

import com.interstellarchef.Main;
import com.interstellarchef.entity.Entity;
import com.interstellarchef.gui.GamePanel;

public class Shell extends Entity {

    public Shell(GamePanel gp) {
        super(gp);

        name = Main.objects[13].getName();
        description = name + Main.objects[13].getDescription();
        down1 = setup("/object/shell", gp.tileSize, gp.tileSize);
    }
}
