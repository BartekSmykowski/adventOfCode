package year2017.Day8;

import java.util.HashMap;
import java.util.Map;

public class RegistersContainer {
    private Map<String, Register> registers;
    private int highestEver;

    public RegistersContainer(){
        registers = new HashMap<>();
        highestEver = Integer.MIN_VALUE;
    }

    public boolean contains(String name){
        return registers.containsKey(name);
    }

    public void addRegisterIfNotExists(String name){
        if(!contains(name)) {
            registers.put(name, new Register(name));
        }
    }

    public Register getRegister(String name){
        return registers.get(name);
    }

    public void print(){
        for(Register register:registers.values()){
            System.out.println(register.getName() + " " + register.getValue());
        }
    }

    public void makeOperation(String registerName, String operation, int operand){
        getRegister(registerName).makeOperation(operation, operand);
        if(getRegister(registerName).getValue() > highestEver)
            highestEver = getRegister(registerName).getValue();
    }

    public int findLargestValue(){
        int max = Integer.MIN_VALUE;
        for(Register register : registers.values()){
            if(register.getValue() > max)
                max = register.getValue();
        }
        return max;
    }

    public int getHighestEver(){
        return highestEver;
    }

    public int getAmount(){
        return registers.size();
    }
}
