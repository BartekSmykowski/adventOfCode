package year2015.Day3;

import util.FilesReader;

import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static void main(String[] args) {
        String path = "src/year2015/Day3/input.txt";

        List<String> lines = FilesReader.getLines(path);

        List<Direction> directions = new ArrayList<>();
        for(String line : lines){
            for(Character character : line.toCharArray()) {
                directions.add(Direction.getDirection(character));
            }
        }

        Map map = new Map(10000);
        map.performActions(directions);
        System.out.println(map.getNumberOfVisited());
    }

}
