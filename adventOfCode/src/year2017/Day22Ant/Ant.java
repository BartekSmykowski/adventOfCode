package year2017.Day22Ant;

public class Ant {
    private Point position;

    public Ant(Coordinates coordinates, Direction direction){
        position = new Point(coordinates, direction);
    }

    public void move(){
        position.move();
    }

    public void turn(Direction turn){
        position.turn(turn);
    }

    public void makeTurn(Map map){
        NodeState cellColor = map.getMap().getElement(position.getCoordinates());
        if(cellColor.equals(NodeState.CLEAN)){
            turn(Direction.LEFT);
        } else if(cellColor.equals(NodeState.INFECTED)){
            turn(Direction.RIGHT);
        } else if(cellColor.equals(NodeState.FLAGGED)){
            turn(Direction.RIGHT);
            turn(Direction.RIGHT);
        }
        map.getMap().setElement(position.getCoordinates(), NodeState.nextState(cellColor));
        if(map.getMap().getElement(position.getCoordinates()).equals(NodeState.INFECTED))
            map.increaseInfected();
        move();
    }

    public Point getPosition() {
        return position;
    }

    @Override
    public String toString(){
        if(position.getDirection().equals(Direction.UP)){
            return "^";
        } else if(position.getDirection().equals(Direction.DOWN)){
            return "v";
        } else if(position.getDirection().equals(Direction.LEFT)){
            return "<";
        } else if(position.getDirection().equals(Direction.RIGHT)){
            return ">";
        }
        return " ";
    }
}
