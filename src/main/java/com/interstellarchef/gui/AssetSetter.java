package com.interstellarchef.gui;

import com.interstellarchef.entity.Cadet;
import com.interstellarchef.entity.Chef;
import com.interstellarchef.entity.Fanatic;
import com.interstellarchef.entity.Gardener;
import com.interstellarchef.entity.Liaison;
import com.interstellarchef.entity.SMJasper;
import com.interstellarchef.entity.SMKun;
import com.interstellarchef.entity.SMNyckolle;
import com.interstellarchef.entity.SMSam;
import com.interstellarchef.entity.Technician;
import com.interstellarchef.object.Noodles;
import com.interstellarchef.object.Rice;
import com.interstellarchef.object.Spacesuit;
import com.interstellarchef.object.Tomato;
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
        gp.obj[i] = new Noodles(gp);
        gp.obj[i].worldX = gp.tileSize*41;
        gp.obj[i].worldY = gp.tileSize*58;
        i++;
        gp.obj[i] = new Tomato(gp);
        gp.obj[i].worldX = gp.tileSize*38;
        gp.obj[i].worldY = gp.tileSize*58;
        i++;
        gp.obj[i] = new Rice(gp);
        gp.obj[i].worldX = gp.tileSize*36;
        gp.obj[i].worldY = gp.tileSize*63;
        i++;
    }

    public void setNPC() {

        gp.npc[0] = new SMJasper(gp);
        gp.npc[0].worldX = gp.tileSize * 48;
        gp.npc[0].worldY = gp.tileSize * 92;

        gp.npc[1] = new SMSam(gp);
        gp.npc[1].worldX = gp.tileSize * 50;
        gp.npc[1].worldY = gp.tileSize * 91;

        gp.npc[2] = new SMNyckolle(gp);
        gp.npc[2].worldX = gp.tileSize * 53;
        gp.npc[2].worldY = gp.tileSize * 91;

        gp.npc[3] = new SMKun(gp);
        gp.npc[3].worldX = gp.tileSize * 49;
        gp.npc[3].worldY = gp.tileSize * 94;

        gp.npc[4] = new Chef(gp);
        gp.npc[4].worldX = gp.tileSize * 61;
        gp.npc[4].worldY = gp.tileSize * 50;

        gp.npc[5] = new Cadet(gp);
        gp.npc[5].worldX = gp.tileSize * 50;
        gp.npc[5].worldY = gp.tileSize * 61;

        gp.npc[6] = new Gardener(gp);
        gp.npc[6].worldX = gp.tileSize * 62;
        gp.npc[6].worldY = gp.tileSize * 75;

        gp.npc[7] = new Fanatic(gp);
        gp.npc[7].worldX = gp.tileSize * 38;
        gp.npc[7].worldY = gp.tileSize * 75;

        gp.npc[8] = new Liaison(gp);
        gp.npc[8].worldX = gp.tileSize * 40;
        gp.npc[8].worldY = gp.tileSize * 39;

        gp.npc[9] = new Technician(gp);
        gp.npc[9].worldX = gp.tileSize * 58;
        gp.npc[9].worldY = gp.tileSize * 29;
    }
}
