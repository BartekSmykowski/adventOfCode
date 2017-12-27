package year2017.Day18Programs.orders;

import year2017.Day18Programs.programs.Program;
import year2017.Day18Programs.registers.Register;
import year2017.Day18Programs.registers.Registers;

public class MultiplyOrder extends TwoArgumentsOrder {
    public MultiplyOrder(Character destinationName, Value value) {
        super(destinationName, value);
    }

    @Override
    public void execute(Program program) {
        Registers registers = program.gerRegisters();
        Register destination = registers.getRegister(destinationName);
        destination.multiply(value.getValue(registers));
    }

    public String toString(){
        return "mul " + destinationName + " " + value.toString();
    }
}
