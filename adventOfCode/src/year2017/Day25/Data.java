package year2017.Day25;

import java.util.LinkedList;

public class Data {
    private LinkedList<Boolean> data;
    private int currentIndex;

    public Data(){
        currentIndex = 0;
        data = new LinkedList<>();
        data.add(false);
    }

    public void move(Direction direction){
        if(direction.equals(Direction.LEFT)){
            if(currentIndex == 0)
                data.addFirst(false);
            else
                currentIndex--;
        } else if(direction.equals(Direction.RIGHT)){
            if(currentIndex == data.size() - 1)
                data.add(false);
            currentIndex++;
        }
    }

    public int gerChecksum(){
        int sum = 0;
        for(Boolean value:data){
            if(value)
                sum++;
        }
        return sum;
    }

    public boolean getValue(){
        return data.get(currentIndex);
    }

    public void writeValue(boolean value){
        data.set(currentIndex, value);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < data.size();i++){
            boolean value = data.get(i);
            if(i == currentIndex)
                builder.append('[');
            builder.append(value?"1" :"0");
            if(i == currentIndex)
                builder.append(']');
        }
        return builder.toString();
    }
}
