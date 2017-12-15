package year2015;

import util.FilesReader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day2 {

    public static void main(String[] args) {
        String path = "src/year2015/input.txt";
        List<String> lines = FilesReader.getLines(path);
        int sumArea = 0;
        int sumRibbon = 0;

        int area;
        int ribbon;
        for(String line : lines){
            String[] tokens = line.split("x");
            int h = Integer.parseInt(tokens[0]);
            int w = Integer.parseInt(tokens[1]);
            int l = Integer.parseInt(tokens[2]);
            area = 2*h*w + 2*h*l + 2*w*l;
            area += findSmallestArea(h, w, l);
            sumArea += area;

            ribbon = findSmallestLength(h, w, l);
            ribbon += h*w*l;
            sumRibbon += ribbon;
        }

        System.out.println(sumArea);
        System.out.println(sumRibbon);
    }

    private static int findSmallestArea(int h, int w, int l) {
        List<Integer> numbers = Arrays.asList(h, w, l);
        Collections.sort(numbers);

        return numbers.get(0) * numbers.get(1);
    }

    private static int findSmallestLength(int h, int w, int l) {
        List<Integer> numbers = Arrays.asList(h, w, l);
        Collections.sort(numbers);

        return 2*numbers.get(0) + 2*numbers.get(1);
    }

}
