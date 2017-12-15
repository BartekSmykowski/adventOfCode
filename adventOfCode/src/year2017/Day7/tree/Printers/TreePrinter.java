package year2017.Day7.tree.Printers;

import year2017.Day7.tree.Node;
import year2017.Day7.tree.Tree;

public class TreePrinter {
    private Tree tree;

    public TreePrinter(Tree tree){
        this.tree = tree;
    }

    public void printTree(int maxDeep){
        printNode(tree.getRoot(), 0,  maxDeep);
    }

    public void printNode(Node node, int level, int maxLevel){
        if(level < maxLevel) {
            printDeep(node.getName() + ":" + node.getWeight() + ":" + node.getSummaryWeight(), level);
            for (Node child : node.getChildren()) {
                printNode(child, level + 1, maxLevel);
            }
        }
    }
    public void printTree(){
        printNode(tree.getRoot(), 0);
    }

    public void printNode(Node node, int level){
        printDeep(node.getName() + ":" + node.getWeight() + ":" + node.getSummaryWeight(), level);
        for (Node child : node.getChildren()) {
            printNode(child, level + 1);
        }
    }

    public void printDeep(String string, int depth){
        StringBuilder deepLine = new StringBuilder();
        for(int i = 0; i < depth; i++){
            deepLine.append("--");
        }
        deepLine.append(string);
        println(deepLine.toString());
    }

    private void println(String string){
        System.out.println(string);
    }
}
