package year2017.Day19Labirynth;

import util.FilesReader;

import java.util.List;

public class Day19 {

    public static void main(String[] args) {
        String filePath = "src/year2017/Day19Labirynth/input.txt";
        List<String> lines = FilesReader.getLines(filePath);

        Path path = new Path(lines);

        System.out.println(path.getPath());
        System.out.println(path.getLetters());
        System.out.println(path.getPath().size());
    }

}
