package year2017.Day24Domino;

import util.FilesReader;
import year2017.Day24Domino.bridges.Bridges;
import year2017.Day24Domino.domino.Dominoes;

import java.util.List;

public class Day24 {

    public static void main(String[] args) {
        String filePath = "src/year2017/Day24Domino/input.txt";
        List<String> lines = FilesReader.getLines(filePath);

        Dominoes dominoes = new Dominoes(lines);

        Bridges bridges = new Bridges(dominoes);
        System.out.println(bridges.getStrenghtOfLongest());

    }
}
