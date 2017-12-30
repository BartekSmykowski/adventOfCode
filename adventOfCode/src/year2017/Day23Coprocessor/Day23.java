package year2017.Day23Coprocessor;

import util.FilesReader;
import year2017.Day23Coprocessor.programs.Program;

import java.util.List;

public class Day23 {

    public static void main(String[] args) {
        String filePath = "src/year2017/Day23Coprocessor/input.txt";
        List<String> lines = FilesReader.getLines(filePath);

        Program program = new Program(0, lines);
        program.executeOrders();
        System.out.print(program.getMulCounter());
    }

}
