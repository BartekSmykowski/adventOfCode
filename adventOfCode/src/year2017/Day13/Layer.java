package year2017.Day13;

public class Layer {
    private int range;
    private int depth;
    private int scannerPosition;
    private boolean movingDown;

    public Layer(int range, int depth){
        this.range = range;
        this.depth = depth;
        reset();
    }

    public void nextStep(){
        if(movingDown)
            scannerPosition++;
        else
            scannerPosition--;
        if(!scannerInBound()){
            if(movingDown)
                scannerPosition -= 2;
            else
                scannerPosition += 2;
            movingDown = !movingDown;
        }
    }

    private boolean scannerInBound() {
        return scannerPosition >= 0 && scannerPosition < range;
    }

    public void reset(){
        scannerPosition = 0;
        movingDown = true;
    }

    public boolean isColliding(){
        return scannerPosition == 0;
    }

    public int getRange(){
        return range;
    }

    public int getDepth(){
        return depth;
    }

    public int getScannerPosition() {
        return scannerPosition;
    }


}
