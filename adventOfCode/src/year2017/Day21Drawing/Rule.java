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
        PixelsMap inputCopy = new PixelsMap(input);
        if (sideCompare(compareMap, inputCopy)) return true;
        if (sideCompare(compareMap, inputCopy)) return true;
        return false;
    }

    private boolean sideCompare(PixelsMap compareMap, PixelsMap map) {
        for(int i = 0; i < 3; i++){
            map.rotate();
            if(compareMap.equals(map))
                return true;
        }
        map.flipX();
        if(compareMap.equals(map))
            return true;
        return false;
    }

    public PixelsMap getInput() {
        return input;
    }
}
