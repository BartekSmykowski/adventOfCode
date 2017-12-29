package year2017.Day10;

import util.FilesReader;

import java.util.List;

public class Day10 {

    public static void main(String[] args) {
        String path = "src/year2017/Day10/input.txt";
        List<String> lines = FilesReader.getLines(path);

        StringBuilder key = new StringBuilder();
        for(String line : lines){
            key.append(line);
        }

        KnotHash knotHash = new KnotHash();


        System.out.println(knotHash.knotHash(key.toString()));
        System.out.println(knotHash.knotHash(key.toString()));
    }




}
