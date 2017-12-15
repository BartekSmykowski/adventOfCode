package year2017;

import util.FilesReader;

import java.util.ArrayList;
import java.util.List;

public class Day1 {



    public static void main(String[] args) {
        String path = "input.txt";

        List<String> lines = FilesReader.getLines(path);
        List<Integer> numbers = getNumbers(lines);

        int sum = countSum(numbers);

        lines.forEach(System.out::println);
        System.out.println("Result: " + sum);
    }

    private static int countSum(List<Integer> numbers) {
        int sum = 0;
        int numbersSize = numbers.size();
        int jumpLength = numbersSize /2;
        for(int i = 0; i < numbersSize; i++){
            Integer number = numbers.get(i);
            Integer cmpNumber = numbers.get((i+jumpLength)%numbersSize);
            if(areEquals(number, cmpNumber))
                sum += number;
        }
        return sum;
    }

    private static boolean areEquals(Integer cmpNumber, Integer number) {
        return number.compareTo(cmpNumber) == 0;
    }

    private static boolean lastEqualsFirst(List<Integer> numbers) {
        return areEquals(numbers.get(numbers.size()-1), numbers.get(0));
    }

    private static List<Integer> getNumbers(List<String> lines) {
        List<Integer> numbers = new ArrayList<>();
        for(String line : lines){
            for(int i = 0; i < line.length(); i++){
                numbers.add(Integer.parseInt(String.valueOf(line.charAt(i))));
            }
        }
        return numbers;
    }


}
