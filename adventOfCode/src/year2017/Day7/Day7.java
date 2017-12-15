package year2017.Day7;

import year2017.Day7.tree.Forest;
import year2017.Day7.tree.Node;
import year2017.Day7.tree.Printers.TreePrinter;
import year2017.Day7.tree.TreeBalancer;
import util.FilesReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day7 {

    public static void main(String[] args) {
        String path = "src/year2017/Day7/input.txt";

        List<String> lines = FilesReader.getLines(path);

        Forest forest = processLines(lines);

        TreeBalancer treeBallancer = new TreeBalancer(forest.getTrees().get(0));
        System.out.println(treeBallancer.getProperWeightOfUnbalancedChild());
        TreePrinter treePrinter = new TreePrinter(forest.getTrees().get(0));
        treePrinter.printTree(3);
    }

    private static Forest processLines(List<String> lines) {
        Forest forest = new Forest();

        for(String line : lines){
            Node node = parseLine(line);
            forest.addNode(node);
        }

        return forest;
    }

    private static Node parseLine(String line) {
        line = line.replaceAll("[(,>\\-\\\\)\\\\(]", "");
        List<String> tokens = Arrays.asList(line.split(" "));
        return parseTokens(tokens);
    }

    private static Node parseTokens(List<String> tokens) {
        String nodeName = tokens.get(0);
        int weight = Integer.parseInt(tokens.get(1));
        List<Node> children = new ArrayList<>();
        for(int i = 3; i < tokens.size(); i++){
            children.add(new Node(tokens.get(i)));
        }
        return new Node(nodeName, children, weight);
    }

}
