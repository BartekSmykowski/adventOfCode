package year2017.Day22Ant;

public enum Direction {
    LEFT,RIGHT,UP,DOWN, NONE;

    public static Direction getAfterTurn(Direction direction, Direction turn){
        if(turn.equals(LEFT)){
            if(direction.equals(UP))
                return LEFT;
            else if(direction.equals(LEFT))
                return DOWN;
            else if(direction.equals(DOWN))
                return RIGHT;
            else if(direction.equals(RIGHT))
                return UP;
        } else if(turn.equals(RIGHT)){
            if(direction.equals(UP))
                return RIGHT;
            else if(direction.equals(LEFT))
                return UP;
            else if(direction.equals(DOWN))
                return LEFT;
            else if(direction.equals(RIGHT))
                return DOWN;
        }
        return NONE;
    }
}
