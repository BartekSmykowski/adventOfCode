package year2017.Day19Labirynth;

public enum Direction {
    LEFT, RIGHT, UP, DOWN, NONE;

    public static Direction getOposite(Direction direction){
        if(direction.equals(LEFT))
            return RIGHT;
        else if(direction.equals(RIGHT))
            return LEFT;
        else if(direction.equals(UP))
            return DOWN;
        else if(direction.equals(DOWN))
            return UP;

        return NONE;
    }
}
