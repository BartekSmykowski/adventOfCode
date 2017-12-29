package year2017.Day22Ant;

public class Point {
    private Coordinates coordinates;
    private Direction direction;

    public Point(Coordinates coordinates, Direction direction){
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public void move(){
        if(direction.equals(Direction.UP)){
            coordinates.add(new Coordinates(0, -1));
        } else if(direction.equals(Direction.RIGHT)){
            coordinates.add(new Coordinates(1, 0));
        } else if(direction.equals(Direction.DOWN)){
            coordinates.add(new Coordinates(0, 1));
        } else if(direction.equals(Direction.LEFT)){
            coordinates.add(new Coordinates(-1, 0));
        }
    }

    public void turn(Direction turn){
        direction = Direction.getAfterTurn(direction, turn);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Direction getDirection() {
        return direction;
    }
}
