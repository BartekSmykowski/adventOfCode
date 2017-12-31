package year2017.Day25;

import java.util.List;

public class State {
    private Action ifZeroAction;
    private Action ifOneAction;
    private String name;

    public State(List<String> stateLines){
        String[] tokens = stateLines.get(0).split(" ");
        String withDot = tokens[tokens.length - 1];
        name = withDot.substring(0, withDot.indexOf(':'));
        ifZeroAction = new Action(stateLines.subList(2, 5));
        ifOneAction = new Action(stateLines.subList(6, 9));
    }

    public void execute(Machine machine){
        boolean actualValue = machine.getActualValue();
        if(!actualValue)
            ifZeroAction.execute(machine);
        else
            ifOneAction.execute(machine);
    }

    public String getName() {
        return name;
    }
}
