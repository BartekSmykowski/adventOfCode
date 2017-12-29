package year2017.Day19Labirynth;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<List<Character>> map;
    private int width;
    private int height;

    public Map(List<String> lines){
        map = new ArrayList<>();
        for(String line:lines){
            List<Character> row = new ArrayList<>();
            for(char letter : line.toCharArray()){
                row.add(letter);
            }
            map.add(row);
        }
        width = map.get(0).size();
        height = map.size();
    }

    public Character getLetterAt(Point point){
        if(getSignAt(point).equals(Sign.LETTER))
            return getCharacter(point);
        else
            return ' ';
    }

    public Sign getSignAt(Point point){
        if(isInBound(point))
            return Sign.toSign(getCharacter(point));
        else
            return Sign.EMPTY;
    }

    private Character getCharacter(Point point) {
        return map.get(point.getY()).get(point.getX());
    }

    public boolean isInBound(Point point){
        int x = point.getX();
        int y = point.getY();
        return y >= 0 && y < map.size() && x >= 0 && x < map.get(y).size();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
