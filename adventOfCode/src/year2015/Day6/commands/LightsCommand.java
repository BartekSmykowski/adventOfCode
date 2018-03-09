package year2015.Day6.commands;

import year2015.Day6.Lights;
import year2015.Day6.Point;
import year2015.Day6.Rectangle;

public abstract class LightsCommand implements Command {
    protected Lights lights;
    protected Rectangle rectangle;

    public LightsCommand(Lights lights, Rectangle rectangle){
        this.lights = lights;
        this.rectangle = rectangle;
    }

    @Override
    public void execute(){
        for(int i = rectangle.getStart().getX(); i <= rectangle.getEnd().getX(); i++){
            for(int j = rectangle.getStart().getY(); j <= rectangle.getEnd().getY(); j++){
                executeOperation(new Point(i, j));
            }
        }
    }

    public abstract void executeOperation(Point point);
}
