package year2017.Day5;

import util.FilesReader;

import java.util.ArrayList;
import java.util.List;

public class Day5 {

    public static void main(String[] args) {
        String path = "src/year2017.Day5/input.txt";

        List<String> lines = FilesReader.getLines(path);
        List<Integer> jumps = new ArrayList<>();

        for(String line : lines){
            jumps.add(Integer.parseInt(line));
        }

        int index = 0;
        int prevIndex;
        int steps = 0;
        while(isInBound(jumps, index)){
            steps++;
            prevIndex = index;
            index += jumps.get(index);
            Integer prevVal = jumps.get(prevIndex);
            if(prevVal >= 3)
                jumps.set(prevIndex, prevVal - 1);
            else
                jumps.set(prevIndex, prevVal + 1);
        }

        for(Integer jump : jumps){
            System.out.print(jump + " ");
        }
        System.out.println();
        System.out.println("Result: " + steps);
    }

    private static boolean isInBound(List list, int index){
        return index >= 0 && index < list.size();
    }

}
