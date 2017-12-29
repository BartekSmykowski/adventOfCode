package year2017.Day21Drawing;

import java.util.ArrayList;
import java.util.List;

public class PixelsMap {
    private List<List<Boolean>> map;

    public PixelsMap(String pixelString){
        map = new ArrayList<>();
        String[] rows = pixelString.split("/");
        for(String row : rows){
            List<Boolean> pxlRow = new ArrayList<>();
            for(Character character : row.toCharArray()){
                if(character == '#')
                    pxlRow.add(true);
                else if(character == '.')
                    pxlRow.add(false);
            }
            map.add(pxlRow);
        }
    }

    public PixelsMap(int size){
        map = new ArrayList<>();
        for(int j = 0; j < size;j++) {
            List<Boolean> pxlRow = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                pxlRow.add(false);
            }
            map.add(pxlRow);
        }
    }

    public PixelsMap(PixelsMap pixelsMap){
        List<List<Boolean>> copy = new ArrayList<>();
        for(List<Boolean> row:pixelsMap.map){
            List<Boolean> copyRow = new ArrayList<>(row);
            copy.add(copyRow);
        }
        map = copy;
    }

    public boolean equals(PixelsMap compare){
        if(size() != compare.size())
            return false;
        for(int i = 0; i < compare.size(); i++){
            for(int j = 0; j < compare.size(); j++){
                Coordinates coordinates = new Coordinates(i, j);
                if(compare.getAt(coordinates) != getAt(coordinates))
                    return false;
            }
        }
        return true;
    }

    public int size(){
        return map.size();
    }

    public void print() {
        for(int j = 0; j < size();j++){
            for(int i = 0; i < size(); i++){
                System.out.print(getAt(new Coordinates(i, j)) ? "#" : ".");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean getAt(Coordinates from){
        return map.get(from.getY()).get(from.getX());
    }

    public boolean setAt(Coordinates point, boolean value){
        return map.get(point.getY()).set(point.getX(), value);
    }

    public void rotate(){
        PixelsMap copy = new PixelsMap(this);
        for(int j = 0; j < size();j++){
            for(int i = 0; i < size(); i++) {
                setAt(new Coordinates(i, j), copy.getAt(new Coordinates(size() - j - 1, i)));
            }
        }
    }

    public void flipY(){
        PixelsMap copy = new PixelsMap(this);
        for(int j = 0; j < size();j++){
            for(int i = 0; i < size(); i++) {
                setAt(new Coordinates(i, j), copy.getAt(new Coordinates(i, size() - j - 1)));
            }
        }
    }

    public void flipX(){
        PixelsMap copy = new PixelsMap(this);
        for(int j = 0; j < size();j++){
            for(int i = 0; i < size(); i++) {
                setAt(new Coordinates(i, j), copy.getAt(new Coordinates(size() - i - 1, j)));
            }
        }
    }

    public PixelsMap getFragment(Coordinates from, int size){
        PixelsMap fragment = new PixelsMap(size);
        for(int j = 0; j < size;j++){
            for(int i = 0; i < size; i++) {
                Coordinates mapSourceCoordinates = new Coordinates(i + from.getX(), j + from.getY());
                Coordinates fragmentCoordinates = new Coordinates(i, j);
                fragment.setAt(fragmentCoordinates, getAt(mapSourceCoordinates));
            }
        }
        return fragment;
    }

    public void writeFragment(Coordinates from, PixelsMap fragment){
        for(int j = 0; j < fragment.size();j++){
            for(int i = 0; i < fragment.size(); i++) {
                Coordinates mapCoordinates = new Coordinates(i + from.getX(), j + from.getY());
                Coordinates fragmentCoordinates = new Coordinates(i, j);
                setAt(mapCoordinates, fragment.getAt(fragmentCoordinates));
            }
        }
    }

    public int numberOfOn(){
        int result = 0;
        for(int j = 0; j < size();j++) {
            for (int i = 0; i < size(); i++) {
                if (getAt(new Coordinates(i, j)))
                    result++;
            }
        }
        return result;
    }

}
