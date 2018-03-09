package year2015.Day3;

public enum Direction {
    NONE, LEFT, RIGHT, UP, DOWN;

    public static Direction getDirection(Character character) {
        if (character.equals('>')) {
            return RIGHT;
        } else if (character.equals('<')) {
            return LEFT;
        } else if (character.equals('^')) {
            return UP;
        } else if (character.equals('v')) {
            return DOWN;
        }
        return NONE;
    }

}
