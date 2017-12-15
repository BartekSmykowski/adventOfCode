package year2017.Day7.tree;

import year2017.Day7.tree.Printers.TreePrinter;

public class TreeBalancer {

    private Tree tree;
    private TreePrinter treePrinter;
    private int depthhOfUnbalanced;
    private Node deepestNode;

    public TreeBalancer(Tree tree){
        this.tree = tree;
        this.treePrinter = new TreePrinter(tree);
        depthhOfUnbalanced = -1;
        deepestNode = new Node();
        findDeepestUnbalanced();
    }

    public int getProperWeightOfUnbalancedChild(){
        int properWeight = 0;
        Node wrongNode = new Node();

        int properSummaryWeight = 0;
        for(Node child : deepestNode.getChildren()){
            int counterOfDifferent = 0;
            for(Node chidCmp : deepestNode.getChildren()){
                if(child.getName().equals(chidCmp.getName())){
                    continue;
                }
                if(chidCmp.getSummaryWeight() != child.getSummaryWeight())
                    counterOfDifferent++;
                else
                    properSummaryWeight = child.getSummaryWeight();
            }
            if(counterOfDifferent == deepestNode.getChildren().size() - 1){
                wrongNode = child;
                break;
            }
        }

        int difference = wrongNode.getSummaryWeight() - properSummaryWeight;
        properWeight = wrongNode.getWeight() - difference;

        return properWeight;
    }

    public void findDeepestUnbalanced(){
        findDeepestUnbalanced(tree.getRoot(), 0);
    }

    private void findDeepestUnbalanced(Node node, int deep){
        if(!node.isBalanced()) {
            if(deep > depthhOfUnbalanced){
                deepestNode = node;
            }
        }
        for(Node child: node.getChildren()){
            findDeepestUnbalanced(child, deep + 2);
        }
    }

    private void printNodeWithChildren(Node node){
        printNode(node, 0);
        for(Node child : node.getChildren()){
            printNode(child, 1);
        }
    }

    private void printNode(Node node, int deep) {
        StringBuilder text = new StringBuilder();
        text.append(node.getName());
        text.append(":").append(node.getSummaryWeight()).append(":").append(node.getWeight());
        treePrinter.printDeep(text.toString(), deep);
    }

}
