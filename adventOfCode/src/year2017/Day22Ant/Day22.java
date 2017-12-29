package year2017.Day22Ant;

import util.FilesReader;

import java.util.List;

public class Day22 {

    public static void main(String[] args) {
        String filePath = "src/year2017/Day22Ant/input.txt";
        List<String> lines = FilesReader.getLines(filePath);

        Map map = new Map(lines);
        for(int i =0; i <10000000; i++) {
            map.makeTurn();
        }
        //map.print();
        System.out.println(map.howManyInfected());

    }

}
