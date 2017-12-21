package year2017.Day12;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private List<Node> connected;
    private int id;

    public Node(int id) {
        this.id = id;
        connected = new ArrayList<>();
    }

    public void addConnection(Node node){
        connected.add(node);
    }

    public List<Node> getConnected() {
        return connected;
    }

    public int getId(){
        return id;
    }
}
