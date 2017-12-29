package year2017.Day11;

public class Coordinates {

    private int x;
    private int y;
    private int z;
    private int max;

    public Coordinates(){
        this(0,0, 0);
    }

    public Coordinates(int x, int y,int z){
        this.x = x;
        this.y = y;
        this.z = z;
        max = 0;
    }


    public void move(Directions direction) {
        if(direction.equals(Directions.N)){
            x++;
            z--;
        } else if(direction.equals(Directions.NE)){
            x++;
            y--;
        } else if(direction.equals(Directions.SE)){
            z++;
            y--;
        } else if(direction.equals(Directions.S)){
            z++;
            x--;
        } else if(direction.equals(Directions.SW)){
            y++;
            x--;
        } else if(direction.equals(Directions.NW)){
            y++;
            z--;
        }
        int distance = distance(new Coordinates(0, 0, 0));
        if(distance > max)
            max = distance;
    }

    public int distance(Coordinates from){
        int distance = 0;
        int dx = Math.abs(x - from.getX());
        int dy = Math.abs(y - from.getY());
        int dz = Math.abs(z - from.getZ());
        distance = max3(dx, dy, dz);
        return distance;
    }

    private int max3(int dx, int dy, int dz) {
        return Math.max(dx, Math.max(dy, dz));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public  int getMax(){
        return max;
    }

}
