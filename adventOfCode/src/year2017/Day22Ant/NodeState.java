package year2017.Day22Ant;

public enum NodeState {
    CLEAN, WEAK, INFECTED, FLAGGED, NONE;

    public static NodeState nextState(NodeState state){
        if(state.equals(CLEAN))
            return WEAK;
        else if(state.equals(WEAK))
            return INFECTED;
        else if(state.equals(INFECTED))
            return FLAGGED;
        else if(state.equals(FLAGGED))
            return CLEAN;
        return NONE;
    }

    public static Character toChar(NodeState state){
        if(state.equals(CLEAN))
            return 'c';
        else if(state.equals(WEAK))
            return 'w';
        else if(state.equals(INFECTED))
            return 'i';
        else if(state.equals(FLAGGED))
            return 'f';
        return ' ';
    }
}
