package year2017.Day12;

import util.FilesReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day12 {

    public static void main(String[] args) {
        String path = "src/year2017/Day12/input.txt";
        List<String> lines = FilesReader.getLines(path);
        Map<Integer, Node> nodes = new HashMap<>();


        for(String line : lines){
            line = line.replace(",", "");
            String[] tokens = line.split(" ");
            int id = Integer.parseInt(tokens[0]);
            nodes.put(id, new Node(id));
        }

        for(String line : lines){
            line = line.replace(",", "");
            String[] tokens = line.split(" ");
            int id = Integer.parseInt(tokens[0]);
            for(int i = 2; i < tokens.length;i++){
                int idConnected = Integer.parseInt(tokens[i]);
                nodes.get(id).addConnection(nodes.get(idConnected));
            }
        }

        int numberOfGroups = 0;
        while(nodes.size() > 0) {
            BFS bfs = new BFS(nodes.get(nodes.keySet().toArray()[0]));
            System.out.println(bfs.getNumberOfConnected());
            for (Node node : bfs.getNodesInGroup()) {
                nodes.remove(node.getId());
            }
            numberOfGroups++;
        }
        System.out.println("Groups no: " + numberOfGroups);

    }
}
