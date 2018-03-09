package year2015.Day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Map {
    private List<List<Boolean>> map;
    private Santa santa;
    private Santa roboSanta;

    public Map(int size){
        santa = new Santa(new Point(size/2, size/2));
        roboSanta = new Santa(new Point(size/2, size/2));
        map = new ArrayList<>();
        for(int i = 0;i < size;i++){
            List<Boolean> row = new ArrayList<>(Collections.nCopies(size, false));
            map.add(row);
        }
    }

    public void setAsVisited(Point point){
        map.get(point.x).set(point.y, true);
    }

    public void performActions(List<Direction> directions){
        setAsVisited(santa.getPosition());
        for(int i = 0;i < directions.size()/2;i++){
            santa.move(directions.get(2*i));
            setAsVisited(santa.getPosition());
            roboSanta.move(directions.get(2*i + 1));
            setAsVisited(roboSanta.getPosition());
        }
    }

    public void print(){
        for(List<Boolean> row: map){
            for(Boolean state:row){
                System.out.print(state?"#":".");
            }
            System.out.println();
        }
    }

    public int getNumberOfVisited() {
        int sum = 0;
        for(List<Boolean> row: map){
            for(Boolean state:row){
                if(state){
                    sum++;
                }
            }
        }
        return sum;
    }
}
