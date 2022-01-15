package game;

import java.io.Serializable;

public class dataStorage implements Serializable {
    //menu stats
    int tax,year,currentSeason,gold;
    String currentEvent1,currentEvent2;
    //dragon stats
    int dragonAttackPoint,dragonLevel,dragonHP;
    float dragonCritChance,dragonAccuracy;
    //wall stats
    int wallHP;
    float wallBlockPercentage;
    //tower stats
    int towerAttackPoint;
    float towerCritChance,towerAccuracy;
    //emotions stats
    int emotional,nervous,lazy,berserk,diligent,fearless;
}
