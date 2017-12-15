package year2017.Day10;

import java.util.ArrayList;
import java.util.List;

public class HashList {
    private List<Integer> list;
    private int currentIndex;
    private int skip;

    public HashList(int size){
        list = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            list.add(i);
        }
        currentIndex = 0;
        skip = 0;
    }

    public void doStep(int length){
        for(int i = 0; i < length/2; i++){
            int index = (currentIndex + length - i - 1) % list.size();
            int index2 = (currentIndex + i)%list.size();
            int tmp = list.get(index);
            int tmp2 = list.get(index2);
            list.set(index, tmp2);
            list.set(index2, tmp);
        }
        currentIndex += skip;
        currentIndex += length;
        currentIndex %= list.size();
        skip++;
    }

    public List<Integer> getList(){
        return list;
    }

    public int get(int index){
        return list.get(index);
    }

    public int getCurrentIndex() {
        return currentIndex;
    }
}
