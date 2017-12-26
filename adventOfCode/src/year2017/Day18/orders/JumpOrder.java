package year2017.Day18.orders;

import year2017.Day18.registers.Registers;

public class JumpOrder implements Order {
    private Value threshold;
    private Value offset;
    private Orders orders;

    public JumpOrder(Value threshold, Value offset, Orders orders) {
        this.threshold = threshold;
        this.offset = offset;
        this.orders = orders;
    }

    @Override
    public void execute(Registers registers) {
        if(threshold.getValue(registers) > 0)
            orders.jump((int) (offset.getValue(registers) - 1));
    }

    public String toString(){
        return "jgz " + threshold.toString() + " " + offset.toString();
    }
}
