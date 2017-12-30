package year2017.Day23Coprocessor.registers;

import java.util.HashMap;
import java.util.Map;

public class Registers {
    private Map<Character, Register> registers;
    private long lastPlayed;

    public Registers() {
        registers = new HashMap<>();
        lastPlayed = 0;
    }

    public Register getRegister(char name) {
        return registers.get(name);
    }

    public void addRegister(Register register){
        if(!registers.containsKey(register.getName()))
            registers.put(register.getName(), register);
    }

    public boolean isRegisterExists(Register register){
        return registers.containsKey(register.getName());
    }

    public void setLastPlayed(long lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public long getLastPlayed() {
        return lastPlayed;
    }

    public Map<Character, Register> getRegisters() {
        return registers;
    }
}
