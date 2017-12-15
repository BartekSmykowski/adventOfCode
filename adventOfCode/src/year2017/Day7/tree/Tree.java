package year2017.Day7.tree;

public class Tree {
    private Node root;

    public Tree(Node root){
        this.root = root;
    }

    public Tree(){
        root = new Node();
    }

    public void addNode(Node node){
        if(root.isNull()){
            root = node;
        }
        Node nodeIfExist = findNode(node.getName());
        if(!nodeIfExist.isNull()){
            nodeIfExist.setChildren(node.getChildren());
        }
    }

    public Node findNode(String name) {
        return findNodeRecur(root, name);
    }

    private Node findNodeRecur(Node node, String searchedName) {
        if(node.getName().equals(searchedName)){
            return node;
        }
        for(Node child : node.getChildren()){
            Node foundNode = findNodeRecur(child, searchedName);
            if(!foundNode.isNull())
                return foundNode;
        }
        return new Node();
    }

    public Node getRoot(){
        return root;
    }


}
