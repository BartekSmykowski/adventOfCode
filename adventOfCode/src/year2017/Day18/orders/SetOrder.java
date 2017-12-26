package year2017.Day18.orders;

import year2017.Day18.registers.Registers;

public class SetOrder extends TwoArgumentsOrder {

    public SetOrder(Character destinationName, Value value){
        super(destinationName, value);
    }

    @Override
    public void execute(Registers registers) {
        registers.getRegister(destinationName).setValue(value.getValue(registers));
    }

    public String toString(){
        return "set " + destinationName + " " + value.toString();
    }

}
