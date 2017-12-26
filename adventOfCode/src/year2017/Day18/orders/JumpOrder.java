package year2017.Day18.orders;

import year2017.Day18.programs.Program;
import year2017.Day18.registers.Registers;

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
    public void execute(Registers registers) {
        if(threshold.getValue(registers) > 0)
            program.jump((int) (offset.getValue(registers) - 1));
    }

    public String toString(){
        return "jgz " + threshold.toString() + " " + offset.toString();
    }
}
