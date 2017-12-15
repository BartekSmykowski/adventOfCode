package year2017.Day9;

import year2017.Day9.entities.Entity;
import year2017.Day9.entities.Garbage;
import year2017.Day9.entities.Group;

public class GarbageLettersCounter {
    private Group group;

    public GarbageLettersCounter(Group group) {
        this.group = group;
    }

    public int getLettersCount(){
        return getLettersCount(group);
    }

    private int getLettersCount(Group group){
        int score = 0;
        for(Entity child: group.getChildren()){
            if(child instanceof Group)
                score += getLettersCount((Group)child);
            else if(child instanceof Garbage)
                score += ((Garbage) child).getNumberOfLetters();
        }
        return score;
    }
}
