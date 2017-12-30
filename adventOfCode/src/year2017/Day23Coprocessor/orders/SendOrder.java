package year2017.Day23Coprocessor.orders;


import year2017.Day23Coprocessor.programs.Communicate;
import year2017.Day23Coprocessor.programs.CommunicationBus;
import year2017.Day23Coprocessor.programs.Program;
import year2017.Day23Coprocessor.registers.Registers;

public class SendOrder implements Order {
    private Value frequency;

    public SendOrder(Value frequency){
        this.frequency = frequency;
    }

    @Override
    public void execute(Program program) {
        Registers registers = program.gerRegisters();
        CommunicationBus.sendCommunicate(new Communicate(frequency.getValue(registers), program.getId()));
    }

    public String toString(){
        return "snd " + frequency.toString();
    }
}
