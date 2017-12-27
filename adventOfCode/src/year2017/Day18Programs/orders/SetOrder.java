package year2017.Day18Programs.orders;

import year2017.Day18Programs.programs.Program;
import year2017.Day18Programs.registers.Registers;

public class SetOrder extends TwoArgumentsOrder {

    public SetOrder(Character destinationName, Value value){
        super(destinationName, value);
    }

    @Override
    public void execute(Program program) {
        Registers registers = program.gerRegisters();
        registers.getRegister(destinationName).setValue(value.getValue(registers));
    }

    public String toString(){
        return "set " + destinationName + " " + value.toString();
    }

}
