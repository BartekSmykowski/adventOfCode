package year2017.Day21Drawing;

import util.FilesReader;

import java.util.List;

public class Day21 {

    public static void main(String[] args) {
        String filePath = "src/year2017/Day21Drawing/input.txt";
        List<String> lines = FilesReader.getLines(filePath);

        Rules rules = new Rules(lines);
        Drawing drawing = new Drawing(rules);
        drawing.print();
        for(int i = 0; i < 3; i++){
            drawing.evolve();
            //drawing.print();
            System.out.println(i);
        }
        System.out.println(drawing.numberOfOn());
    }

}
