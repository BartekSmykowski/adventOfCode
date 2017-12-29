package year2017.Day15;

public class Generator {
    private long value;
    private int multiplier;
    private int criteria;
    public static int DIVIDER = 2147483647;

    public Generator(int startValue, int multiplier, int criteria){
        this.multiplier = multiplier;
        this.value = startValue;
        this.criteria = criteria;
    }

    public void nextValid(){
        nextStep();
        while(value%criteria != 0) {
            nextStep();
        }
    }

    private void nextStep() {
        long multiply = value * multiplier;
        value = multiply % DIVIDER;
    }

    public long getValue(){
        return value;
    }

    public long get16BitsValue(){
        return value%(int)Math.pow(2, 16);
    }
}
