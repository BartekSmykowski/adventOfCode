package year2017.Day21Drawing;

public class Coordinates {
    private int x;
    private int y;


    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(Coordinates coordinates){
        x += coordinates.x;
        y += coordinates.y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

}
