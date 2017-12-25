package year2017.Day16;

import util.FilesReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day16 {

    public static void main(String[] args) {
        String path = "src/year2017/Day16/input.txt";
        List<String> lines = FilesReader.getLines(path);


        List<String> orders = new ArrayList<>();
        for(String line:lines){
            orders.addAll(Arrays.asList(line.split(",")));
        }

        Programs programs = new Programs();
        print(programs);
        for(int i = 0; i < 1000000000;i++) {
            for (String order : orders) {
                programs.makeOrder(order);
            }
            if(i%1000 == 0){
                System.out.println(i);
            }
            if(areEquals(programs.getPrograms(), programs.getFirstPrograms())){
                System.out.println("equals!!!!!!");
                System.out.println(i);
                for(int j = 0; j < 1000000000%(i + 1); j++){
                    for (String order : orders) {
                        programs.makeOrder(order);
                    }
                    System.out.print(j + " ");
                    print(programs);
                }
                break;
            }
        }


    }

    private static void print(Programs programs) {
        for(char program: programs.getPrograms()){
            System.out.print(program);
        }
        System.out.println();
    }

    private static boolean areEquals(List<Character> first, List<Character> second){
        boolean areEquals = true;
        for(int i = 0; i < first.size(); i++){
            if(!first.get(i).equals(second.get(i)))
                areEquals = false;
        }
        return areEquals;
    }

}
