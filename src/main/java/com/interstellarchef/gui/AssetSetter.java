package com.interstellarchef.gui;


import com.interstellarchef.entity.Alien;
import com.interstellarchef.entity.Alien2;
import com.interstellarchef.entity.Cadet;
import com.interstellarchef.entity.Chef;
import com.interstellarchef.entity.DesertMON;
import com.interstellarchef.entity.Fanatic;
import com.interstellarchef.entity.ForestMON;
import com.interstellarchef.entity.Gardener;
import com.interstellarchef.entity.LavaMON;
import com.interstellarchef.entity.Liaison;
import com.interstellarchef.entity.Pod;
import com.interstellarchef.entity.SMFelix;
import com.interstellarchef.entity.SMJasper;
import com.interstellarchef.entity.SMKun;
import com.interstellarchef.entity.SMNyckolle;
import com.interstellarchef.entity.SMSam;
import com.interstellarchef.entity.Shadow;
import com.interstellarchef.entity.SnowMON;
import com.interstellarchef.entity.Technician;
import com.interstellarchef.object.Butter;
import com.interstellarchef.object.Crystal;
import com.interstellarchef.object.Curry;
import com.interstellarchef.object.Door;
import com.interstellarchef.object.Fish;
import com.interstellarchef.object.Flour;
import com.interstellarchef.object.Frog;
import com.interstellarchef.object.GPS;
import com.interstellarchef.object.Key;
import com.interstellarchef.object.Lamb;
import com.interstellarchef.object.Lightning;
import com.interstellarchef.object.Meatball;
import com.interstellarchef.object.Milk;
import com.interstellarchef.object.Noodles;
import com.interstellarchef.object.Pepper;
import com.interstellarchef.object.Powder;
import com.interstellarchef.object.Rice;
import com.interstellarchef.object.Rock;
import com.interstellarchef.object.Salsa;
import com.interstellarchef.object.Shell;
import com.interstellarchef.object.Snacks;
import com.interstellarchef.object.Spacesuit;
import com.interstellarchef.object.Tofu;
import com.interstellarchef.object.Tomato;
import com.interstellarchef.object.Tortillas;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        int i = 0;
        gp.obj[i] = new Spacesuit(gp);
        gp.obj[i].worldX = gp.tileSize*38;
        gp.obj[i].worldY = gp.tileSize*57;
        i++;
//        gp.obj[i] = new Noodles(gp);
//        gp.obj[i].worldX = gp.tileSize*49;
//        gp.obj[i].worldY = gp.tileSize*59;
//        i++;
//        gp.obj[i] = new Tomato(gp);
//        gp.obj[i].worldX = gp.tileSize*50;
//        gp.obj[i].worldY = gp.tileSize*59;
//        i++;
//        gp.obj[i] = new Rice(gp);
//        gp.obj[i].worldX = gp.tileSize*51;
//        gp.obj[i].worldY = gp.tileSize*59;
//        i++;
//        gp.obj[i] = new Butter(gp);
//        gp.obj[i].worldX = gp.tileSize*52;
//        gp.obj[i].worldY = gp.tileSize*59;
//        i++;
//        gp.obj[i] = new Crystal(gp);
//        gp.obj[i].worldX = gp.tileSize*48;
//        gp.obj[i].worldY = gp.tileSize*60;
//        i++;
//        gp.obj[i] = new Curry(gp);
//        gp.obj[i].worldX = gp.tileSize*49;
//        gp.obj[i].worldY = gp.tileSize*60;
//        i++;
//        gp.obj[i] = new Fish(gp);
//        gp.obj[i].worldX = gp.tileSize*50;
//        gp.obj[i].worldY = gp.tileSize*60;
//        i++;
//        gp.obj[i] = new Flour(gp);
//        gp.obj[i].worldX = gp.tileSize*51;
//        gp.obj[i].worldY = gp.tileSize*60;
//        i++;
//        gp.obj[i] = new Frog(gp);
//        gp.obj[i].worldX = gp.tileSize*52;
//        gp.obj[i].worldY = gp.tileSize*60;
//        i++;
//        gp.obj[i] = new GPS(gp);
//        gp.obj[i].worldX = gp.tileSize*48;
//        gp.obj[i].worldY = gp.tileSize*61;
//        i++;
//        gp.obj[i] = new Key(gp);
//        gp.obj[i].worldX = gp.tileSize*49;
//        gp.obj[i].worldY = gp.tileSize*61;
//        i++;
//        gp.obj[i] = new Lamb(gp);
//        gp.obj[i].worldX = gp.tileSize*50;
//        gp.obj[i].worldY = gp.tileSize*61;
//        i++;
//        gp.obj[i] = new Lightning(gp);
//        gp.obj[i].worldX = gp.tileSize*51;
//        gp.obj[i].worldY = gp.tileSize*61;
//        i++;
//        gp.obj[i] = new Meatball(gp);
//        gp.obj[i].worldX = gp.tileSize*52;
//        gp.obj[i].worldY = gp.tileSize*61;
//        i++;
//        gp.obj[i] = new Milk(gp);
//        gp.obj[i].worldX = gp.tileSize*48;
//        gp.obj[i].worldY = gp.tileSize*62;
//        i++;
//        gp.obj[i] = new Pepper(gp);
//        gp.obj[i].worldX = gp.tileSize*49;
//        gp.obj[i].worldY = gp.tileSize*62;
//        i++;
//        gp.obj[i] = new Powder(gp);
//        gp.obj[i].worldX = gp.tileSize*50;
//        gp.obj[i].worldY = gp.tileSize*62;
//        i++;
//        gp.obj[i] = new Rock(gp);
//        gp.obj[i].worldX = gp.tileSize*51;
//        gp.obj[i].worldY = gp.tileSize*62;
//        i++;
//        gp.obj[i] = new Salsa(gp);
//        gp.obj[i].worldX = gp.tileSize*52;
//        gp.obj[i].worldY = gp.tileSize*62;
//        i++;
//        gp.obj[i] = new Shell(gp);
//        gp.obj[i].worldX = gp.tileSize*48;
//        gp.obj[i].worldY = gp.tileSize*63;
//        i++;
//        gp.obj[i] = new Snacks(gp);
//        gp.obj[i].worldX = gp.tileSize*49;
//        gp.obj[i].worldY = gp.tileSize*63;
//        i++;
//        gp.obj[i] = new Tofu(gp);
//        gp.obj[i].worldX = gp.tileSize*50;
//        gp.obj[i].worldY = gp.tileSize*63;
//        i++;
//        gp.obj[i] = new Tortillas(gp);
//        gp.obj[i].worldX = gp.tileSize*51;
//        gp.obj[i].worldY = gp.tileSize*63;
//        i++;
        gp.obj[i] = new Door(gp);
        gp.obj[i].worldX = gp.tileSize*55;
        gp.obj[i].worldY = gp.tileSize*61;
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

        gp.npc[10] = new Pod(gp);
        gp.npc[10].worldX = gp.tileSize * 42;
        gp.npc[10].worldY = gp.tileSize * 29;

        gp.npc[11] = new SMFelix(gp);
        gp.npc[11].worldX = gp.tileSize * 60;
        gp.npc[11].worldY = gp.tileSize * 39;

        gp.npc[12] = new Shadow(gp);
        gp.npc[12].worldX = gp.tileSize * 61;
        gp.npc[12].worldY = gp.tileSize * 60;

        gp.npc[13] = new Technician(gp);
        gp.npc[13].worldX = gp.tileSize * 58;
        gp.npc[13].worldY = gp.tileSize * 29;

        gp.npc[14] = new Alien(gp);
        gp.npc[14].worldX = gp.tileSize * 9;
        gp.npc[14].worldY = gp.tileSize * 91;

        gp.npc[15] = new Alien2(gp);
        gp.npc[15].worldX = gp.tileSize * 91;
        gp.npc[15].worldY = gp.tileSize * 93;

        gp.npc[16] = new ForestMON(gp);
        gp.npc[16].worldX = gp.tileSize * 12;
        gp.npc[16].worldY = gp.tileSize * 6;

        gp.npc[17] = new LavaMON(gp);
        gp.npc[17].worldX = gp.tileSize * 11;
        gp.npc[17].worldY = gp.tileSize * 84;

        gp.npc[18] = new DesertMON(gp);
        gp.npc[18].worldX = gp.tileSize * 88;
        gp.npc[18].worldY = gp.tileSize * 84;

        gp.npc[19] = new SnowMON(gp);
        gp.npc[19].worldX = gp.tileSize * 84;
        gp.npc[19].worldY = gp.tileSize * 8;

    }
}
