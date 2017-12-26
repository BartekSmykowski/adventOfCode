package year2017.Day18;

import year2017.Day18.registers.Registers;

public class Printer {

    public static void printRegisters(Registers registers){
        registers.getRegisters().forEach((k, v)->System.out.print(k + ": " + v.getValue() + " "));
        System.out.println();
    }

}
