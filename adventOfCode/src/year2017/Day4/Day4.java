package year2017.Day4;

import util.FilesReader;

import java.util.Arrays;
import java.util.List;

public class Day4 {

    public static void main(String[] args) {
        String path = "src/year2017.Day4/input.txt";

        List<String> lines = FilesReader.getLines(path);

        int counter = 0;

        for(String line : lines){
            if(isValid2(line)){
                counter++;
            }
        }

        for(String line : lines) {
            System.out.println(line + " " + isValid2(line));
        }
        System.out.println("Result: " + counter);

    }

    private static boolean isValid(String line) {
        boolean isValid = true;
        String[] words = line.split(" ");
        for(int i = 0; i < words.length; i++){
           for (int j = 0; j < words.length; j++){
               if(j != i && words[i].equals(words[j]))
                   isValid = false;
           }
        }
        return isValid;
    }

    private static boolean isValid2(String line) {
        boolean isValid = true;
        String[] words = line.split(" ");
        for(int i = 0; i < words.length; i++){
            for (int j = 0; j < words.length; j++){
                if(j != i && areAnagrams(words[i], words[j]))
                    isValid = false;
            }
        }


        boolean isEmployee = Math.random() < 0.5;
        int dayPayRate = 2;
        int daysWorked  = 0;
        int weeklyPay  = 10;




        if(isEmployee) {
            weeklyPay = daysWorked * dayPayRate;
        } //weeklyPay - hours worked in week multiplied by
          //pay rate for one hour


        double b = weeklyPay++;


        return isValid;
    }

    private static boolean areAnagrams(String word, String cmpWord) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        char[] cmpChars = cmpWord.toCharArray();
        Arrays.sort(cmpChars);

        String sortedWord = new String(chars);
        String sortedCmpWord = new String(cmpChars);
        return sortedWord.equals(sortedCmpWord);
    }

}
