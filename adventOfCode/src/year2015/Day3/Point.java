package year2015.Day3;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(){
        this(0,0);
    }

    public void move(Direction direction){
        if (direction.equals(Direction.RIGHT)) {
            x++;
        } else if (direction.equals(Direction.LEFT)) {
            x--;
        } else if (direction.equals(Direction.UP)) {
            y--;
        } else if (direction.equals(Direction.DOWN)) {
            y++;
        }
    }

}
