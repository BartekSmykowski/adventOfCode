package year2017.Day18Programs.registers;

public class Register {
    private long value;
    private char name;

    public Register(char name){
        this.name = name;
        value = 0;
    }

    public void add(long by){
        value += by;
    }

    public void multiply(long by){
        value *= by;
    }

    public void modulo(long by){
        value %= by;
    }

    public void setValue(long value){
        this.value = value;
    }

    public char getName() {
        return name;
    }

    public long getValue() {
        return value;
    }
}
