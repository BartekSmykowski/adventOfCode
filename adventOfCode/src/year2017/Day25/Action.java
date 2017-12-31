package year2017.Day25;

import java.util.List;

public class Action {
    private Direction direction;
    private String nextStateName;
    private boolean value;

    public Action(List<String> lines){
        value = getValue(lines.get(0));
        direction = getDirection(lines.get(1));
        nextStateName = getNextStateName(lines.get(2));
    }

    private String getNextStateName(String line) {
        String[] tokens = line.split(" ");
        String withDot = tokens[tokens.length - 1];
        return withDot.substring(0, withDot.indexOf('.'));
    }

    private boolean getValue(String line) {
        String[] tokens = line.split(" ");
        return tokens[tokens.length - 1].charAt(0) == '1';
    }

    private Direction getDirection(String line) {
        String[] tokens = line.split(" ");
        String withDot = tokens[tokens.length - 1];
        String directionName = withDot.substring(0, withDot.indexOf('.'));
        return Direction.valueOf(directionName.toUpperCase());
    }

    public void execute(Machine machine) {
        machine.writeValue(value);
        machine.move(direction);
        machine.changeState(nextStateName);
    }
}
