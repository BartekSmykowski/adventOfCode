package year2017.Day18.orders;

import year2017.Day18.registers.Register;
import year2017.Day18.registers.Registers;

public class MultiplyOrder extends TwoArgumentsOrder {
    public MultiplyOrder(Character destinationName, Value value) {
        super(destinationName, value);
    }

    @Override
    public void execute(Registers registers) {
        Register destination = registers.getRegister(destinationName);
        destination.multiply(value.getValue(registers));
    }

    public String toString(){
        return "mul " + destinationName + " " + value.toString();
    }
}
