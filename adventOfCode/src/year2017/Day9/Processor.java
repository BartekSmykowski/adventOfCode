package year2017.Day9;

import year2017.Day9.entities.CharProcessor;
import year2017.Day9.entities.Entity;
import year2017.Day9.entities.Garbage;
import year2017.Day9.entities.Group;

public class Processor implements CharProcessor {

    private Entity processor;

    public Processor(){
        processor = null;
    }

    @Override
    public void processChar(char character) {
        if(processor != null){
            if(!processor.isEnded()){
                processor.processChar(character);
            }
            return;
        }
        if(character == '<'){
            processor = new Garbage(null);
        } else if(character == '{'){
            processor = new Group(null, 1);
        }
    }

    public Entity getProcessor() {
        return processor;
    }
}
