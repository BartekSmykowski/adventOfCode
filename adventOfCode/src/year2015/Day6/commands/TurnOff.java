package year2015.Day6.commands;

import year2015.Day6.Lights;
import year2015.Day6.Point;
import year2015.Day6.Rectangle;

public class TurnOff extends LightsCommand {

    public TurnOff(Lights lights, Rectangle rectangle) {
        super(lights, rectangle);
    }

    @Override
    public void executeOperation(Point point) {
        lights.turnOff(point);
    }
}
