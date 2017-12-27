package year2017.Day18Programs.orders;

import year2017.Day18Programs.programs.Program;
import year2017.Day18Programs.registers.Registers;

public class JumpOrder implements Order {
    private Value threshold;
    private Value offset;
    private Program program;

    public JumpOrder(Value threshold, Value offset, Program program) {
        this.threshold = threshold;
        this.offset = offset;
        this.program = program;
    }

    @Override
    public void execute(Program program) {
        Registers registers = program.gerRegisters();
        if(threshold.getValue(registers) > 0)
            program.jump((int) (offset.getValue(registers) - 1));
    }

    public String toString(){
        return "jgz " + threshold.toString() + " " + offset.toString();
    }
}
