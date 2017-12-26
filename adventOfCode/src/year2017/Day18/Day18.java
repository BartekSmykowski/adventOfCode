package year2017.Day18;

import util.FilesReader;
import year2017.Day18.programs.Programs;

import java.util.List;

public class Day18 {

    public static void main(String[] args) {
        String path = "src/year2017/Day18/input.txt";
        List<String> lines = FilesReader.getLines(path);

        Programs programs = new Programs(lines);

        programs.executePrograms();
    }

}
