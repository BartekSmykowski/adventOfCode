package year2015.Day5;

import util.FilesReader;
import util.GlobalConstatns;

import java.util.ArrayList;
import java.util.List;

public class Day5 {
    private static List<String> specialStrings = new ArrayList<String>() {{
        add("ab");
        add("cd");
        add("pq");
        add("xy");
    }};
    private static String vowels = "aeiou";

    public static void main(String[] args) {
        String path = GlobalConstatns.getPath(2015, 5);
        List<String> lines = FilesReader.getLines(path);

        int numberOfNice = 0;
        for(String line:lines){
            if(isNice(line)){
                numberOfNice++;
            }
        }
        System.out.println(numberOfNice);
    }

    public static boolean isNice(String line){
        if(!containsTwoPairs(line))
            return false;
        else if(!twiceWthBreak(line))
            return false;
        return true;
    }

    private static boolean containsTwoPairs(String line) {
        for(int i = 0; i < line.length() - 1; i++){
            String subString = line.substring(i,i+2);
            for(int j = 0; j < line.length() - 1;j++){
                if(Math.abs(i-j) >= 2) {
                    String secondSubString = line.substring(j, j + 2);
                    if(secondSubString.equals(subString)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean containsStrings(String line) {
        for(String special:specialStrings){
            if(line.contains(special)){
                return true;
            }
        }
        return false;
    }

    private static boolean twiceInRow(String line) {
        for(int i = 0; i < line.length() - 1; i++){
            if(line.charAt(i) == line.charAt(i+1)){
                return true;
            }
        }
        return false;
    }

    private static boolean twiceWthBreak(String line) {
        for(int i = 0; i < line.length() - 2; i++){
            if(line.charAt(i) == line.charAt(i+2)){
                return true;
            }
        }
        return false;
    }

    private static boolean containsTreeVowels(String line) {
        int numberOfVowels = 0;
        for(Character character:line.toCharArray()){
            if(vowels.contains(character.toString())){
                numberOfVowels++;
            }
        }
        return numberOfVowels >= 3;
    }


}
