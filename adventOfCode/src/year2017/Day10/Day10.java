package year2017.Day10;

import util.FilesReader;

import java.util.ArrayList;
import java.util.List;

public class Day10 {

    public static void main(String[] args) {
        String path = "src/year2017/Day10/input.txt";
        List<String> lines = FilesReader.getLines(path);

        List<Integer> lenghts = new ArrayList<>();

        for(String line : lines){
            String[] tokens = line.split(",");
            for(int i = 0; i < tokens.length; i++){
                lenghts.add(Integer.parseInt(tokens[i]));
            }
        }

        HashList hashList = new HashList(256);
        HashListPrinter hashListPrinter = new HashListPrinter(hashList);
        hashListPrinter.printWithMarkedCurrentIndex();
        for(Integer length:lenghts){
            hashList.doStep(length);
            System.out.println(length);
            hashListPrinter.printWithMarkedCurrentIndex();
        }

        System.out.println();
        int first = hashList.get(0);
        int second = hashList.get(1);
        System.out.println(first * second);
        hashListPrinter.printWithMarkedCurrentIndex();
    }



}
