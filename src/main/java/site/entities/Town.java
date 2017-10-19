package site.entities;

import site.enums.Element;

import javax.persistence.*;

@Entity
@Table(name = "towns")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.ORDINAL)
    private Element element;

    @OneToOne
    private TownCoordinate townCoordinate;

    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    public Town() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
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
