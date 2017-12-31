package year2017.Day25;

import java.util.List;

public class Machine {
    private State currentState;
    private States states;
    private Data data;

    public Machine(List<String> lines){
        states = new States(lines.subList(3, lines.size()));
        currentState = states.getState(getFirstStateName(lines));
        data = new Data();
    }
    public void doTakt(){
        currentState.execute(this);
    }

    private String getFirstStateName(List<String> lines) {
        return String.valueOf(lines.get(0).charAt(lines.get(0).length() - 2));
    }

    public void changeState(String name){
        currentState = states.getState(name);
    }

    public void move(Direction direction){
        data.move(direction);
    }

    public void writeValue(boolean value){
        data.writeValue(value);
    }

    public boolean getActualValue(){
        return data.getValue();
    }

    public void print(){
        System.out.println(currentState.getName() + " " + data);
    }

    public int getChecksum(){
        return data.gerChecksum();
    }
}
