package year2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day3 {
    private static int number = 325489;

    public static void main(String[] args) {
        List<List<Integer>> square = generateSquare(10);
        for(List<Integer> line:square){
            for(Integer number : line){
                System.out.printf("%5d ", number);
            }
            System.out.println();
        }
    }

    private static int estimateNumberOfSquares(int number) {
        int numberOfSquares = 0;
        double sqrt = Math.sqrt(number);
        sqrt += 1;
        sqrt /= 2;
        numberOfSquares = (int) Math.ceil(sqrt);
        return numberOfSquares;
    }

    private static int measureDistance(int number) {
        int distance;
        int numberOfSquares = estimateNumberOfSquares(number);
        int edgeLength = numberOfSquares*2-1;
        List<List<Integer>> square = generateSquare(numberOfSquares);
        int middlePos = numberOfSquares - 1;
        int x = middlePos;
        int y = middlePos;
        for(int i = 0; i < edgeLength; i++){
            for(int j = 0; j < edgeLength; j++){
                if(square.get(i).get(j).compareTo(number) == 0){
                    x = i;
                    y = j;
                }
            }
        }
        distance = Math.abs(middlePos - x) + Math.abs(middlePos - y);
        return distance;
    }

    public static List<List<Integer>> generateSquare(int numberOfSquares){
        int edgeLength = numberOfSquares*2-1;
        List<Integer> xs = generateXs(numberOfSquares);
        List<Integer> ys = generateYs(numberOfSquares);
        List<List<Integer>> square = new ArrayList<>(edgeLength);
        for(int i = 0;i < edgeLength; i++){
            List<Integer> line = new ArrayList<>(Collections.nCopies(edgeLength, 0));
            square.add(line);
        }
        boolean found = false;
        int x;
        int y;
        int value = 1;
        setValue(square, numberOfSquares - 1, numberOfSquares - 1, 1);
        for(int i = 1; i < edgeLength*edgeLength; i++){
            x = xs.get(i);
            y = ys.get(i);
            value++;
            //value = measureValue(square, x, y);
            if(!found && value > number) {
                found = true;
                System.out.println(value);
            }
            setValue(square, x, y, value);
        }
        return square;
    }

    private static int measureValue(List<List<Integer>> square, int x, int y) {
        int value = 0;
        int newX;
        int newY;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                newX = x - 1 + i;
                newY = y - 1 + j;
                if((newX != x || newY != y) && areInBound(square, newX, newY)){
                    value += square.get(newX).get(newY);
                }
            }
        }
        return value;
    }

    private static boolean areInBound(List<List<Integer>> square, int newX, int newY) {
        int lastIndex = square.size() - 1;
        return newX >= 0 && newX <= lastIndex && newY >= 0 && newY <= lastIndex;
    }

    private static List<Integer> generateYs(int numberOfSquares) {
        List<Integer> ys = new ArrayList<>();
        int middlePos = numberOfSquares - 1;
        ys.add(middlePos);
        for(int i = 1; i < numberOfSquares; i++) {
            for(int j = 0; j < i*2; j++){
                ys.add(middlePos + i - j - 1);
            }
            for(int j = 0; j < i*2; j++){
                ys.add(middlePos - i);
            }
            for(int j = 0; j < i*2; j++){
                ys.add(middlePos - i + j + 1);
            }
            for(int j = 0; j < i*2; j++){
                ys.add(middlePos + i);
            }
        }
        return ys;
    }

    private static List<Integer> generateXs(int numberOfSquares){
        List<Integer> xs = new ArrayList<>();
        int middlePos = numberOfSquares - 1;
        xs.add(middlePos);
        for(int i = 1; i < numberOfSquares; i++) {
            for(int j = 0; j < i*2; j++){
                xs.add(middlePos + i);
            }
            for(int j = 0; j < i*2; j++){
                xs.add(middlePos + i - j - 1);
            }
            for(int j = 0; j < i*2; j++){
                xs.add(middlePos - i);
            }
            for(int j = 0; j < i*2; j++){
                xs.add(middlePos - i + j + 1);
            }
        }
        return xs;
    }

    private static void setValue(List<List<Integer>> square, int x, int y, int value){
        square.get(x).set(y, value);
    }

}
