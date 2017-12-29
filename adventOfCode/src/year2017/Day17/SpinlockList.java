package year2017.Day17;

import java.util.ArrayList;
import java.util.List;

public class SpinlockList {
    private List<Integer> list;
    private int size;
    private int currentIndex;
    private int skipRange;
    private int after0;

    public SpinlockList(int skipRange){
        this.skipRange = skipRange;
        currentIndex = 0;
        list = new ArrayList<>();
        list.add(0);
        size = 1;
        fillList2();
    }

    private void fillList2() {
        for(int i = 1; i < 50000000;i++){
            int nextIndex = nextIndex();
            if(nextIndex == 0) {
                after0 = i;
            }
            size++;
            currentIndex = nextIndex + 1;
            if(i%1000000 == 0){
                System.out.println(i);
            }
        }
    }

    private void fillList() {
        for(int i = 1; i < 50000000;i++){
            int nextIndex = nextIndex();
            if(nextIndex == 0) {
                list.add(nextIndex + 1, i);
            }
            else {
                list.add(i);
            }
            size++;
            currentIndex = nextIndex + 1;
            if(i%1000000 == 0){
                System.out.println(i);
            }
        }
    }

    public int nextIndex(){
        int nextIndex;
        nextIndex = (currentIndex + skipRange)%size;
        return nextIndex;
    }

    public List<Integer> getList(){
        return list;
    }

    public int getAfter0() {
        if(list.size() > 1)
            return list.get(1);
        return after0;
    }
}
