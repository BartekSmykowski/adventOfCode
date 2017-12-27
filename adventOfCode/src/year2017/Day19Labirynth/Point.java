package year2017.Day19Labirynth;

public class Point {
    private int x;
    private int y;
    private Direction fromWhere;
    private Sign sign;

    public Point(int x, int y){
        this(x, y, Sign.EMPTY);
    }

    public Point(int x, int y, Sign sign) {
        this(x, y, Direction.NONE, sign);
    }

    public Point(int x, int y, Direction fromWhere, Sign sign) {
        this.x = x;
        this.y = y;
        this.fromWhere = fromWhere;
        this.sign = sign;
    }

    public Point(Point copy) {
        x = copy.x;
        y = copy.y;
        fromWhere = copy.fromWhere;
        sign = copy.sign;
    }

    public void move(Direction direction) {
        if (direction.equals(Direction.DOWN)) {
            y++;
            fromWhere = Direction.UP;
        } else if (direction.equals(Direction.UP)) {
            y--;
            fromWhere = Direction.DOWN;
        } else if (direction.equals(Direction.LEFT)) {
            x--;
            fromWhere = Direction.RIGHT;
        } else if (direction.equals(Direction.RIGHT)) {
            x++;
            fromWhere = Direction.LEFT;
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

    public Direction getFromWhere() {
        return fromWhere;
    }

    public Sign getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return "x:" + x + " y:" + y;
    }
}
