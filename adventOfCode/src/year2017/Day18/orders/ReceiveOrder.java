package year2017.Day18.orders;

import year2017.Day18.registers.Register;
import year2017.Day18.registers.Registers;

public class ReceiveOrder implements Order {

    private Character registerName;

    public ReceiveOrder(Character registerName){

        this.registerName = registerName;
    }

    @Override
    public void execute(Registers registers) {
        Register register = registers.getRegister(registerName);
        long argValue = register.getValue();
        if(argValue > 0){
            register.setValue(registers.getLastPlayed());
        }
    }

    public String toString(){
        return "rcv " + registerName;
    }
}
