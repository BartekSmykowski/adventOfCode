package year2017.Day6;

import util.FilesReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day6 {

    public static void main(String[] args) {
        String path = "src/year2017.Day6/input.txt";

        List<String> lines = FilesReader.getLines(path);

        List<Integer> numbers = parseLines(lines);

        List<List<Integer>> history = new ArrayList<>();
        history.add(new ArrayList<>(numbers));

        int indexOfBefore;
        while(true){
            int maxIndex = findMaxIndex(numbers);
            int max = numbers.get(maxIndex);
            numbers.set(maxIndex, 0);
            for (int i = 0; i < max; i++) {
                int index = (maxIndex + i + 1) % numbers.size();
                numbers.set(index, numbers.get(index) + 1);
            }
            indexOfBefore = indexIfWasBefore(numbers, history);
            if(indexOfBefore != -1)
                break;
            history.add(new ArrayList<>(numbers));
        }

        printHistory(history);

        System.out.println(history.size() - indexOfBefore);

    }

    private static int indexIfWasBefore(List<Integer> numbers, List<List<Integer>> history) {
        int wasBefore = -1;
        for(int i = 0; i < history.size(); i++){
            List<Integer> historyNumbers = history.get(i);
            if(areSame(historyNumbers, numbers))
                wasBefore = i;
        }
        return wasBefore;
    }

    private static void printHistory(List<List<Integer>> history) {
        for(List<Integer> historyNumbers : history){
            historyNumbers.forEach(n -> System.out.print(n + " "));
            System.out.println();
        }
    }

    private static int findMaxIndex(List<Integer> numbers) {
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) > max){
                maxIndex = i;
                max = numbers.get(i);
            }
        }
        return maxIndex;
    }

    private static boolean areSame(List<Integer> first, List<Integer> second){
        boolean areSame = true;
        if(first.size() != second.size())
            return false;
        for(int i = 0; i < first.size(); i++){
            if(!Objects.equals(first.get(i), second.get(i)))
                areSame = false;
        }
        return areSame;
    }

    private static List<Integer> parseLines(List<String> lines) {
        List<Integer> numbers = new ArrayList<>();

        for(String line: lines){
            String[] tokens = line.split("\t");
            for(String token : tokens){
                numbers.add(Integer.parseInt(token));
            }
        }

        return numbers;
    }

}
