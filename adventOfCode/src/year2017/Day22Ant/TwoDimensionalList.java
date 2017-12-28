package year2017.Day22Ant;

import java.util.ArrayList;
import java.util.List;

public class TwoDimensionalList<T> {
    private List<List<T>> list;

    public TwoDimensionalList(int size, T defaultValue){
        list = new ArrayList<>();
        for(int i  =0;i < size; i++){
            List<T> row = new ArrayList<>();
            for(int j = 0; j < size;j++){
                row.add(defaultValue);
            }
            list.add(row);
        }
    }

    public void setElement(Coordinates coordinates, T element){
        if(isInBound(coordinates))
            list.get(coordinates.getY()).set(coordinates.getX(), element);
    }

    public T getElement(Coordinates coordinates){
        if(isInBound(coordinates))
            return list.get(coordinates.getY()).get(coordinates.getX());
        return null;
    }

    public boolean isInBound(Coordinates coordinates){
        int x = coordinates.getX();
        int y = coordinates.getY();
        if(!(y>=0 && y < list.size()))
            return false;
        return y >=0&& y < list.get(0).size();
    }

    public int size(){
        return list.size();
    }
}
