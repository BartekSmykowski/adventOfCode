package year2017.Day12;

import java.util.ArrayList;
import java.util.List;

public class BFS {

    private Node root;
    private List<Node> visited;

    public BFS(Node root){
        this.root = root;
        visited = new ArrayList<>();
        bfs(root);
    }

    public int getNumberOfConnected(){
        return visited.size();
    }

    private void bfs(Node root) {
        visited.add(root);
        for(Node node : root.getConnected()){
            if(!visited.contains(node)){
                bfs(node);
            }
        }
    }

    public List<Node> getNodesInGroup(){
        return visited;
    }

}
