package year2017.Day7.tree;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private List<Node> children;
    private int weight;

    public Node(String name, List<Node> children, int weight){
        this.name = name;
        this.children = children;
        this.weight = weight;
    }

    public Node(String name){
        this(name, new ArrayList<>(), 0);
    }

    public Node(){
        this("");
    }

    public boolean isBalanced(){
        if(children.size() == 0)
            return true;

        int cmpWeight = children.get(0).getSummaryWeight();
        for(int i = 1; i < children.size(); i++){
            if(children.get(i).getSummaryWeight() != cmpWeight)
                return false;
        }

        return true;
    }

    public int getSummaryWeight(){
        int summaryWeight = weight;
        for(Node child: children){
            summaryWeight += child.getSummaryWeight();
        }
        return summaryWeight;
    }

    public List<Node> getChildren(){
        return children;
    }

    public String getName(){
        return name;
    }

    public void setChildren(List<Node> children){
        this.children = children;
    }

    public boolean isNull(){
        return name.equals("");
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
