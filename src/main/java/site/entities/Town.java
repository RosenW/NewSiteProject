package site.entities;

import site.enums.Faction;
import site.enums.LandType;

import javax.persistence.*;

@Entity
@Table(name = "towns")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Faction faction;

    @Enumerated(EnumType.STRING)
    private LandType landType;

    @OneToOne
    private TownCoordinate townCoordinate;

    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    public Town() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LandType getLandType() {
        return landType;
    }

    public void setLandType(LandType landType) {
        this.landType = landType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public TownCoordinate getTownCoordinate() {
        return townCoordinate;
    }

    public void setTownCoordinate(TownCoordinate townCoordinate) {
        this.townCoordinate = townCoordinate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
