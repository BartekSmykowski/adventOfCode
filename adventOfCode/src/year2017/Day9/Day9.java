package year2017.Day9;

import util.FilesReader;
import year2017.Day9.entities.Group;

import java.util.List;

public class Day9 {
    public static void main(String[] args) {
        String path = "src/year2017/Day9/input.txt";

        List<String> lines = FilesReader.getLines(path);

        Processor processor = new Processor();

        for(String line:lines){
            char[] characters = line.toCharArray();
            for(int i =0; i < characters.length; i++){
                processor.processChar(characters[i]);
            }
        }

        EntityPrinter groupPrinter = new EntityPrinter(processor.getProcessor());
        groupPrinter.print();

        EntityScoreCounter scoreCounter = new EntityScoreCounter((Group) processor.getProcessor());
        System.out.println(scoreCounter.getScore());

        GarbageLettersCounter lettersCounter = new GarbageLettersCounter((Group) processor.getProcessor());
        System.out.println(lettersCounter.getLettersCount());
    }

}
