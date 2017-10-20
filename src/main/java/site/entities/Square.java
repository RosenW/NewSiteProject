package site.entities;

import site.enums.LandType;

import javax.persistence.*;

@Table(name = "world")
@Entity
public class Square {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int bigX;
    private int bigY;
    private int smallX;
    private int smallY;
    @Enumerated(EnumType.ORDINAL)
    private LandType landType;

    public Square(int bx, int by, int sx, int sy) {
        this.setBigX(bx);
        this.setBigY(by);
        this.setSmallX(sx);
        this.setSmallY(sy);
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

    public LandType getLandType() {
        return landType;
    }

    public void setLandType(LandType landType) {
        this.landType = landType;
    }

    public Square() {
    }
}
