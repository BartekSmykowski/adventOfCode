package year2017.Day22Ant;

import java.util.List;

public class Map {
    private TwoDimensionalList<NodeState> map;
    private Ant ant;
    private int BORDER = 300;
    private int infected;

    public Map(List<String> lines){
        map = new TwoDimensionalList<>(lines.size() + BORDER * 2, NodeState.CLEAN);
        for(int j =0; j < lines.size(); j++){
            String line = lines.get(j);
            for(int i = 0; i < line.toCharArray().length; i++){
                Character character = line.charAt(i);
                NodeState value = NodeState.NONE;
                if(character == '#')
                    value = NodeState.INFECTED;
                else if(character == '.')
                    value = NodeState.CLEAN;
                map.setElement(new Coordinates(i + BORDER, j + BORDER), value);
            }
        }
        int middle = map.size()/2;
        ant = new Ant(new Coordinates(middle, middle), Direction.UP);
        infected = 0;
    }

    public TwoDimensionalList<NodeState> getMap() {
        return map;
    }

    public void makeTurn(){
        ant.makeTurn(this);
    }

    public void print(){
        for(int j =0; j < map.size(); j++) {
            for (int i = 0; i < map.size(); i++) {
                if(i == ant.getPosition().getCoordinates().getX() && j == ant.getPosition().getCoordinates().getY())
                    System.out.print(ant.toString());
                else
                    System.out.print(NodeState.toChar(map.getElement(new Coordinates(i, j))));
            }
            System.out.println();
        }
        System.out.println();
    }

    public void increaseInfected() {
        infected++;
    }

    public int howManyInfected() {
        return infected;
    }
}
