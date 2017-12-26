package year2017.Day18.orders;

import year2017.Day18.registers.Register;
import year2017.Day18.registers.Registers;

public class ModuloOrder extends TwoArgumentsOrder {
    public ModuloOrder(Character destinationName, Value value) {
        super(destinationName, value);
    }

    @Override
    public void execute(Registers registers) {
        Register destination = registers.getRegister(destinationName);
        destination.modulo(value.getValue(registers));
    }

    public String toString(){
        return "mod " + destinationName + " " + value.toString();
    }
}
