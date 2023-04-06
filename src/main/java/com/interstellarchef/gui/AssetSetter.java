package com.interstellarchef.gui;

import com.interstellarchef.entity.SMJasper;
import com.interstellarchef.entity.SMKun;
import com.interstellarchef.entity.SMNyckolle;
import com.interstellarchef.entity.SMSam;
import com.interstellarchef.object.Spacesuit;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        int i = 0;
        gp.obj[i] = new Spacesuit(gp);
        gp.obj[i].worldX = gp.tileSize*38;
        gp.obj[i].worldY = gp.tileSize*63;
        i++;
    }

    public void setNPC() {

        gp.npc[1] = new SMSam(gp);
        gp.npc[1].worldX = gp.tileSize * 63;
        gp.npc[1].worldY = gp.tileSize * 75;

        gp.npc[2] = new SMNyckolle(gp);
        gp.npc[2].worldX = gp.tileSize * 62;
        gp.npc[2].worldY = gp.tileSize * 75;

        gp.npc[3] = new SMKun(gp);
        gp.npc[3].worldX = gp.tileSize * 64;
        gp.npc[3].worldY = gp.tileSize * 75;
    }
}
