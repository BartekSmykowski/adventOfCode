package year2017.Day25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class States {
    private Map<String, State> states;

    public States(List<String> lines){
        states = new HashMap<>();
        int linesCounter = 0;
        List<String> stateLines = new ArrayList<>();
        for(String line: lines){
            linesCounter++;
            if(linesCounter != 10)
                stateLines.add(line);
            if(linesCounter == 9){
                addState(new State(stateLines));
                stateLines.clear();
            }
            if(linesCounter == 10)
                linesCounter = 0;
        }
    }

    public void addState(State state){
        states.put(state.getName(), state);
    }

    public State getState(String name){
        return states.get(name);
    }

}