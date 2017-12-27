package year2017.Day18Programs.orders;

import year2017.Day18Programs.programs.Program;

public class ReceiveOrder implements Order {

    private Character registerName;

    public ReceiveOrder(Character registerName){

        this.registerName = registerName;
    }

    @Override
    public void execute(Program program) {
        program.receiveFromQueue(registerName);
//        Register register = registers.getRegister(registerName);
//        long argValue = register.getValue();
//        if(argValue > 0){
//            register.setValue(registers.getLastPlayed());
//        }
    }

    public String toString(){
        return "rcv " + registerName;
    }
}
