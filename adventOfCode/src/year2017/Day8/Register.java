package year2017.Day8;

public class Register {
    private String name;
    private int value;

    public Register(String name){
        this.name = name;
    }

    public void makeOperation(String operation, int by){
        if(operation.equals("inc")){
            inc(by);
        } else if(operation.equals("dec")){
            dec(by);
        }
    }

    public void inc(int by){
        value += by;
    }

    public void dec(int by){
        value -= by;
    }

    public int getValue(){
        return value;
    }

    public String getName(){
        return name;
    }

}
