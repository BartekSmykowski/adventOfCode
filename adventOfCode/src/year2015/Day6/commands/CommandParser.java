package year2015.Day6.commands;

import year2015.Day6.Lights;
import year2015.Day6.Point;
import year2015.Day6.Rectangle;

public class CommandParser {
    public static LightsCommand parse(Lights lights, String line){
        String[] tokens = line.split(" ");
        Point start = parsePoint(tokens[tokens.length - 3]);
        Point end = parsePoint(tokens[tokens.length - 1]);
        Rectangle rectangle = new Rectangle(start, end);
        if(tokens[0].equals("toggle")){
            return new Toggle(lights, rectangle);
        } else if(tokens[0].equals("turn")){
            if(tokens[1].equals("on")){
                return new TurnOn(lights, rectangle);
            }else if(tokens[1].equals("off")){
                return new TurnOff(lights, rectangle);
            }
        }
        return null;
    }

    private static Point parsePoint(String pointString){
        String[] tokens = pointString.split(",");
        int x = Integer.parseInt(tokens[0]);
        int y = Integer.parseInt(tokens[1]);
        return new Point(x, y);
    }

}
