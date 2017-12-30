package year2017.Day23Coprocessor.orders;


import year2017.Day23Coprocessor.registers.Registers;

public class Value {
    private String arg;
    private long value;
    private Character registerName;
    private boolean isNumber;

    public Value(String arg){
        this.arg = arg;
        if(isInteger(arg)) {
            value = Integer.parseInt(arg);
            isNumber = true;
        }
        else {
            registerName = arg.charAt(0);
            isNumber = false;
        }
    }

    public long getValue(Registers registers){
        if(isNumber)
            return value;
        else
            return registers.getRegister(registerName).getValue();
    }

    public static boolean isInteger(String input){
        try{
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public String toString() {
        return arg;
    }
}
