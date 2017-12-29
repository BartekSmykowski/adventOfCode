package year2017.Day18Programs.orders;

import year2017.Day18Programs.programs.Communicate;
import year2017.Day18Programs.programs.CommunicationBus;
import year2017.Day18Programs.programs.Program;
import year2017.Day18Programs.registers.Registers;

public class SendOrder implements Order {
    private Value frequency;

    public SendOrder(Value frequency){
        this.frequency = frequency;
    }

    @Override
    public void execute(Program program) {
        Registers registers = program.gerRegisters();
        //registers.setLastPlayed(frequency.getValue(registers));
        CommunicationBus.sendCommunicate(new Communicate(frequency.getValue(registers), program.getId()));
    }

    public String toString(){
        return "snd " + frequency.toString();
    }
}
