package year2017;

import util.FilesReader;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static void main(String[] args) {
        String path = "input2.txt";

        List<String> lines = FilesReader.getLines(path);

        lines.forEach(System.out::println);

        int sum = 0;
        for(String line : lines){
            List<Integer> numbers = parseLine(line);
            int division = findDivision(numbers);
            System.out.print(division + " ");
            sum += division;
        }

        System.out.println();
        System.out.println("Result: " + sum);
    }

    private static List<Integer> parseLine(String line) {
        List<Integer> numbers = new ArrayList<>();
        String[] numbersTokens = line.split("\t");
        for(String token : numbersTokens){
            numbers.add(Integer.parseInt(token));
        }
        return numbers;
    }

    private static int findDifference(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(Integer number : numbers){
            if(number < min)
                min = number;
            if(number > max)
                max = number;
        }
        return max - min;
    }

    private static int findDivision(List<Integer> numbers) {

        int first;
        int second;
        int division = 0;

        for(Integer number : numbers){
            first = number;
            for(Integer number2 :  numbers){
                if(number.equals(number2)) {
                    continue;
                }
                second = number2;
                if(first % second == 0){
                    division = first/second;
                }
                if(second % first == 0){
                    division = second/first;
                }
            }
        }

        return division;
    }
}
