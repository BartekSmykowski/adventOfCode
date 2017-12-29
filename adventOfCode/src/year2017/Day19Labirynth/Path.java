package year2017.Day19Labirynth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Path {
    private Map map;
    private Direction currentDirection;
    private Point currentPosition;
    private List<Point> path;
    private StringBuilder letters;

    public Path(List<String> lines){
        letters = new StringBuilder();
        map = new Map(lines);
        currentDirection = Direction.DOWN;
        path = new ArrayList<>();
        initPath();
    }

    private void initPath() {
        path.add(getFirstPoint());
        Point nextPoint = getNextPoint();
        while(nextPoint != null){
            path.add(nextPoint);
            if(map.getSignAt(nextPoint).equals(Sign.LETTER))
                letters.append(map.getLetterAt(nextPoint));
            nextPoint = getNextPoint();
            System.out.println(nextPoint);
        }
    }

    public Point getFirstPoint(){
        for(int i = 0; i < map.getWidth(); i++){
            Point nextPoint = new Point(i, 0);
            Sign signAt = map.getSignAt(nextPoint);
            if(signAt.equals(Sign.VERTICAL)){
                Point point = new Point(i, 0, Direction.getOposite(currentDirection), Sign.VERTICAL);
                currentPosition = point;
                return point;
            }
        }
        return null;
    }

    public Point getNextPoint(){
        Point result = null;

        if(map.getSignAt(currentPosition).equals(Sign.CROSS)){
            List<Direction> possibleDirections = new ArrayList<>(Arrays.asList(Direction.values()));
            possibleDirections.remove(currentPosition.getFromWhere());
            possibleDirections.remove(currentDirection);
            possibleDirections.remove(Direction.NONE);
            for(Direction possibleDirection: possibleDirections){
                Point newPosition = new Point(currentPosition);
                newPosition.move(possibleDirection);
                if(!map.getSignAt(newPosition).equals(Sign.EMPTY)){
                    result = newPosition;
                    currentPosition = result;
                    currentDirection = Direction.getOposite(result.getFromWhere());
                    return result;
                }
            }
        } else {
            Point newPosition = new Point(currentPosition);
            newPosition.move(currentDirection);
            if(!map.getSignAt(newPosition).equals(Sign.EMPTY)) {
                result = newPosition;
                currentPosition = result;
                currentDirection = Direction.getOposite(result.getFromWhere());
                return result;
            }
        }

        return result;
    }

    public List<Point> getPath() {
        return path;
    }

    public String getLetters(){
        return letters.toString();
    }
}
