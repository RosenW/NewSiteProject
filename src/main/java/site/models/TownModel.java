package site.models;

import site.entities.TownCoordinate;
import site.enums.Faction;
import site.enums.LandType;

public class TownModel {
    private Faction faction;
    private TownCoordinate coordinate;
    private String owner;
    private String name;
    private LandType landType;

    public TownModel(Faction faction, TownCoordinate coordinate) {
        this.faction = faction;
        this.coordinate = coordinate;
    }

    public TownModel() {

    }

    public LandType getLandType() {
        return landType;
    }

    public void setLandType(LandType landType) {
        this.landType = landType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public TownCoordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(TownCoordinate coordinate) {
        this.coordinate = coordinate;
    }
}
