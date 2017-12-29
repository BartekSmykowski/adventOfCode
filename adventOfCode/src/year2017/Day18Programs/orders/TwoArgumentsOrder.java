package year2017.Day18Programs.orders;

public abstract class TwoArgumentsOrder implements Order {
    protected Character destinationName;
    protected Value value;

    public TwoArgumentsOrder(Character destinationName, Value value){

        this.destinationName = destinationName;
        this.value = value;
    }

}
