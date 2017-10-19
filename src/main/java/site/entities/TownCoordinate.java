package site.entities;

import javax.persistence.*;

@Entity
@Table(name = "coordinates")
public class TownCoordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int bigX;
    private int bigY;
    private int smallX;
    private int smallY;

    @OneToOne
    private Town town;

    public TownCoordinate() {
    }

    public TownCoordinate(int bigX, int bigY, int smallX, int smallY) {
        setBigX(bigX);
        setBigY(bigY);
        setSmallX(smallX);
        setSmallY(smallY);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBigX() {
        return bigX;
    }

    public void setBigX(int bigX) {
        this.bigX = bigX;
    }

    public int getBigY() {
        return bigY;
    }

    public void setBigY(int bigY) {
        this.bigY = bigY;
    }

    public int getSmallX() {
        return smallX;
    }

    public void setSmallX(int smallX) {
        this.smallX = smallX;
    }

    public int getSmallY() {
        return smallY;
    }

    public void setSmallY(int smallY) {
        this.smallY = smallY;
    }
}
