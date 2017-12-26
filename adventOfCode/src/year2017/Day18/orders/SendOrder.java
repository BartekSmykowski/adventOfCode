package year2017.Day18.orders;

import year2017.Day18.registers.Registers;

public class SendOrder implements Order {
    private Value frequency;

    public SendOrder(Value frequency){
        this.frequency = frequency;
    }

    @Override
    public void execute(Registers registers) {
        registers.setLastPlayed(frequency.getValue(registers));
    }

    public String toString(){
        return "snd " + frequency.toString();
    }
}
