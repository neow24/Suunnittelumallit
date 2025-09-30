package prototypeWar;

public class Director {
    public void constructInfantrySoldier(SoldierBuilder builder) {
        builder.addGenericItem("Armour");
        builder.addWeapon("Rifle");
        builder.addGenericItem("Helmet");
    }
}
