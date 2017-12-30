package year2017.Day23Coprocessor.orders;

import year2017.Day23Coprocessor.programs.Program;
import year2017.Day23Coprocessor.registers.Registers;

public class JumpNotZeroOrder implements Order {
    private Value threshold;
    private Value offset;
    private Program program;

    public JumpNotZeroOrder(Value threshold, Value offset, Program program) {
        this.threshold = threshold;
        this.offset = offset;
        this.program = program;
    }

    @Override
    public void execute(Program program) {
        Registers registers = program.gerRegisters();
        if(threshold.getValue(registers) != 0)
            program.jump((int) (offset.getValue(registers) - 1));
    }

    public String toString(){
        return "jnz " + threshold.toString() + " " + offset.toString();
    }
}
