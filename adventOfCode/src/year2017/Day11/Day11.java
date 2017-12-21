package year2017.Day11;

import util.FilesReader;

import java.util.ArrayList;
import java.util.List;

public class Day11 {

    public static void main(String[] args) {
        String path = "src/year2017/Day11/input.txt";
        List<String> lines = FilesReader.getLines(path);

        List<Directions> directions = new ArrayList<>();

        for(String line : lines){
            String[] tokens = line.split(",");
            for(int i = 0; i < tokens.length; i++){
                directions.add(Directions.valueOf(tokens[i].toUpperCase()));
            }
        }

        Coordinates coordinates = new Coordinates();

        for(Directions direction : directions){
            coordinates.move(direction);
        }

        System.out.println(coordinates.distance(new Coordinates(0,0,0)));
        System.out.println(coordinates.getMax());
    }

}
