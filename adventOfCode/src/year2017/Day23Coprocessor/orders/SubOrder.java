package year2017.Day23Coprocessor.orders;


import year2017.Day23Coprocessor.programs.Program;
import year2017.Day23Coprocessor.registers.Register;
import year2017.Day23Coprocessor.registers.Registers;

public class SubOrder extends TwoArgumentsOrder {

    public SubOrder(Character destinationName, Value value) {
        super(destinationName, value);
    }

    @Override
    public void execute(Program program) {
        Registers registers = program.gerRegisters();
        Register destination = registers.getRegister(destinationName);
        destination.sub(value.getValue(registers));
    }

    public String toString(){
        return "sub " + destinationName + " " + value.toString();
    }
}
