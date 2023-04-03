package com.interstellarchef.gui;

import com.interstellarchef.entity.SMJasper;
import com.interstellarchef.entity.SMKun;
import com.interstellarchef.entity.SMNyckolle;
import com.interstellarchef.entity.SMSam;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

    }

    public void setNPC() {
        gp.npc[0] = new SMJasper(gp);
        gp.npc[0].worldX = gp.tileSize * 62;
        gp.npc[0].worldY = gp.tileSize * 76;

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
