package year2017.Day25;

import util.FilesReader;

import java.util.List;

public class Day25 {

    public static void main(String[] args) {
        String filePath = "src/year2017/Day25/input.txt";
        List<String> lines = FilesReader.getLines(filePath);

        Machine machine = new Machine(lines);
        machine.print();
        for (int i = 0; i < 12208951; i++) {
            machine.doTakt();
            if(i%100000==0)
                System.out.println(i);
        }
        System.out.println(machine.getChecksum());

    }

}
