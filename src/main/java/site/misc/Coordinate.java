package site.misc;

public class Coordinate {
    private int x;
    private int y;
    private int size;

    public Coordinate(int x, int y, int size) {
        setX(x);
        setY(y);
        setSize(size);
    }

    public int moveRight() {
        if (x == size-1) {
            return 0;
        } else {
            return this.getX() + 1;
        }
    }

    public int moveLeft() {
        if (x == 0) {
            return size-1;
        } else {
            return this.getX() - 1;
        }
    }

    public int moveUp() {
        if (y == 0) {
            return size-1;
        } else {
            return this.getY() - 1;
        }
    }

    public int moveDown() {
        if (y == size-1) {
            return 0;
        } else {
            return this.getY()+1;
        }
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
