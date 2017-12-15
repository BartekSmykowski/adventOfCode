package year2017.Day7.tree.Printers;

import year2017.Day7.tree.Forest;
import year2017.Day7.tree.Tree;

public class ForestPrinter {

    private Forest forest;

    public ForestPrinter(Forest forest){
        this.forest = forest;
    }

    public void print(){
        for(Tree tree:forest.getTrees()){
            TreePrinter treePrinter = new TreePrinter(tree);
            treePrinter.printTree();
            System.out.println();
            System.out.println();
        }
    }
}
