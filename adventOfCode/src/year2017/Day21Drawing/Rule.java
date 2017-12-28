package year2017.Day21Drawing;

public class Rule {
    private PixelsMap input;
    private PixelsMap output;

    public Rule(String line){
        String[] tokens = line.split(" ");
        input = new PixelsMap(tokens[0]);
        output = new PixelsMap(tokens[2]);
    }

    public PixelsMap getOutput(){
        return output;
    }

    public boolean compareToInput(PixelsMap compareMap){
        if (sideCompare(compareMap)) return true;
        if (sideCompare(compareMap)) return true;
        return false;
    }

    private boolean sideCompare(PixelsMap compareMap) {
        for(int i = 0; i < 3; i++){
            input.rotate();
            if(compareMap.equals(input))
                return true;
        }
        input.flipX();
        if(compareMap.equals(input))
            return true;
        return false;
    }

    public PixelsMap getInput() {
        return input;
    }
}
