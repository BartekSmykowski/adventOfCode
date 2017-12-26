package year2017.Day18.orders;

import year2017.Day18.registers.Register;
import year2017.Day18.registers.Registers;

public class AddOrder extends TwoArgumentsOrder {

    public AddOrder(Character destinationName, Value value) {
        super(destinationName, value);
    }

    @Override
    public void execute(Registers registers) {
        Register destination = registers.getRegister(destinationName);
        destination.add(value.getValue(registers));
    }

    public String toString(){
        return "add " + destinationName + " " + value.toString();
    }
}
