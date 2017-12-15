package year2017.Day9.entities;

import java.util.ArrayList;
import java.util.List;

public class Group extends Entity {
    private List<Entity> children;
    private Entity processor;
    private int score;

    public Group(Entity parent, int score){
        super(parent);
        children = new ArrayList<>();
        processor = null;
        this.score = score;
        allSigns.append('{');
    }

    @Override
    public void processChar(char character) {
        allSigns.append(character);
        if(ignoreNext){
            ignoreNext = false;
            return;
        }
        if(processor != null) {
            if(!processor.isEnded()){
                processor.processChar(character);
                return;
            } else {
                processor = null;
            }
        }

        if(character == '<'){
            Garbage garbage = new Garbage(this);
            processor = garbage;
            children.add(garbage);
            return;
        } else if(character == '{'){
            Group group = new Group(this, score + 1);
            processor = group;
            children.add(group);
            return;
        }

        if(character == '!'){
            ignoreNext = true;
        } else if(character == '}'){
            isEnded = true;
        }
    }

    public List<Entity> getChildren() {
        return children;
    }

    public int getScore(){
        return score;
    }

}
