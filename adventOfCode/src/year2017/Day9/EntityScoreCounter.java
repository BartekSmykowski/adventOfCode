package year2017.Day9;

import year2017.Day9.entities.Entity;
import year2017.Day9.entities.Group;

public class EntityScoreCounter {
    private Group group;

    public EntityScoreCounter(Group group) {
        this.group = group;
    }

    public int getScore(){
        return getScore(group);
    }

    private int getScore(Group group){
        int score = 0;
        score += group.getScore();
        for(Entity child: group.getChildren()){
            if(child instanceof  Group)
                score += getScore((Group)child);
        }
        return score;
    }
}
