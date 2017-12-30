package year2017.Day23Coprocessor.orders;


import year2017.Day23Coprocessor.programs.Program;

public class ReceiveOrder implements Order {

    private Character registerName;

    public ReceiveOrder(Character registerName){

        this.registerName = registerName;
    }

    @Override
    public void execute(Program program) {
        program.receiveFromQueue(registerName);
    }

    public String toString(){
        return "rcv " + registerName;
    }
}
