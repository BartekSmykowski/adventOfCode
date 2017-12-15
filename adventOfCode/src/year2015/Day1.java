package year2015;

import util.FilesReader;

import java.util.List;

public class Day1 {

    public static void main(String[] args) {

        String  path = "src/year2015/input.txt";

        List<String> lines = FilesReader.getLines(path);
        String line = lines.get(0);

        int floor = 0;
        int whichChar = -1;
        char[] chars = line.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char parenthesis = chars[i];
            if(parenthesis == '(')
                floor++;
            if(parenthesis == ')')
                floor--;

            if(floor == -1){
                whichChar = i + 1;
                break;
            }
        }
        System.out.println(floor);
        System.out.println(whichChar);

        for(int i = 0; i < whichChar - 1; i++){
            System.out.print(chars[i]);
        }
        System.out.print("   " + chars[whichChar - 1] + "   ");
        for(int i = whichChar; i < chars.length; i++){
            System.out.print(chars[i]);
        }

    }

}
