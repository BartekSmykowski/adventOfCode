package year2017.Day21Drawing;

import java.util.ArrayList;
import java.util.List;

public class Drawing {
    private PixelsMap pixelsMap;
    private Rules rules;

    public Drawing(Rules rules){
        this.rules = rules;
        pixelsMap = new PixelsMap(".#./..#/###");
    }

    public void evolve(){
        List<List<PixelsMap>> splited = split();
        List<List<PixelsMap>> evolved = evolveEach(splited);
        pixelsMap = merge(evolved);
    }

    private PixelsMap merge(List<List<PixelsMap>> evolved) {
        int fragmentSize = evolved.get(0).get(0).size();
        int fragmentsNumber = evolved.size();
        PixelsMap merged = new PixelsMap(fragmentsNumber * fragmentSize);
        for(int i = 0; i < fragmentsNumber; i++){
            for(int j = 0; j < fragmentsNumber; j++){
                merged.writeFragment(new Coordinates(i*fragmentSize, j*fragmentSize), evolved.get(j).get(i));
            }
        }
        return merged;
    }

    private List<List<PixelsMap>> evolveEach(List<List<PixelsMap>> splited) {
        List<List<PixelsMap>> evolved = new ArrayList<>();
        for(List<PixelsMap> row: splited){
            List<PixelsMap> rowMaps = new ArrayList<>();
            for(PixelsMap pixelsMap:row){
                PixelsMap evolvedMap = rules.getOutput(pixelsMap);
                rowMaps.add(evolvedMap);
            }
            evolved.add(rowMaps);
        }
        return evolved;
    }

    private List<List<PixelsMap>> split() {
        List<List<PixelsMap>> splited = new ArrayList<>();
        int pixelsMapSize = pixelsMap.size();
        int split = pixelsMapSize;
        if(pixelsMapSize % 2 == 0){
            split = 2;
        } else if(pixelsMapSize % 3 == 0){
            split = 3;
        }
        for(int j = 0; j < pixelsMapSize/split; j++){
            List<PixelsMap> row = new ArrayList<>();
            for(int i = 0; i < pixelsMapSize/split; i++){
                row.add(pixelsMap.getFragment(new Coordinates(i*split, j*split), split));
            }
            splited.add(row);
        }
        return splited;
    }

    public void print(){
        pixelsMap.print();
    }

    public void rotate(){
        pixelsMap.rotate();
    }

    public void flipX(){
        pixelsMap.flipX();
    }

    public void flipY(){
        pixelsMap.flipY();
    }

    public int numberOfOn(){
        return pixelsMap.numberOfOn();
    }

    public PixelsMap getPixelsMap() {
        return pixelsMap;
    }
}
