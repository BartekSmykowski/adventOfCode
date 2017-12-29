package year2017.Day21Drawing;

import java.util.ArrayList;
import java.util.List;

public class Rules {
    private List<Rule> rules;

    public Rules(List<String> lines){
        rules = new ArrayList<>();
        for(String line : lines){
            rules.add(new Rule(line));
        }
    }

    public PixelsMap getOutput(PixelsMap input){
        for(Rule rule : rules){
            if(rule.compareToInput(input)) {
                return rule.getOutput();
            }
        }
        return null;
    }
}
