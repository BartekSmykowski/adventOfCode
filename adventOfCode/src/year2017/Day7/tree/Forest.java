package year2017.Day7.tree;

import java.util.ArrayList;
import java.util.List;

public class Forest {
    private List<Tree> trees;

    public Forest(){
        trees = new ArrayList<>();
    }

    public void addNode(Node node){
        Node foundNode = findNode(node);
        if(!foundNode.isNull()){
            updateExisting(node, foundNode);
        } else {
            addNewTree(node);
        }
        replaceChildrenWithTrees(node);
    }

    private void replaceChildrenWithTrees(Node node) {
        List<Node> children = node.getChildren();
        for(int i = 0; i < children.size(); i++){
            findTreeAndReplace(children, i);
        }
    }

    private void findTreeAndReplace(List<Node> children, int i) {
        Node child = children.get(i);
        for(int j = 0; j < trees.size(); j++){
            Node treeRoot = trees.get(j).getRoot();
            if(treeRoot.getName().equals(child.getName())){
                children.set(i, treeRoot);
                trees.remove(j);
                break;
            }
        }
    }

    private void addNewTree(Node node) {
        Tree newTree = new Tree(node);
        trees.add(newTree);
    }

    private void updateExisting(Node node, Node foundNode) {
        foundNode.setWeight(node.getWeight());
        foundNode.setChildren(node.getChildren());
    }

    private Node findNode(Node node) {
        Node foundNode = new Node();
        for(Tree tree: trees){
            foundNode = tree.findNode(node.getName());
            if(!foundNode.isNull()){
                break;
            }
        }
        return foundNode;
    }

    public List<Tree> getTrees() {
        return trees;
    }
}
