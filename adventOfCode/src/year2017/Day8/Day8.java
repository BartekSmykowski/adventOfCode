package year2017.Day8;

import util.FilesReader;

import java.util.List;

public class Day8 {

    public static void main(String[] args) {
        String path = "src/year2017.Day8/input.txt";
        List<String> lines = FilesReader.getLines(path);

        RegistersContainer registersContainer = new RegistersContainer();

        for(String line : lines){
            String[] tokens = line.split(" ");
            String registerName = tokens[0];
            registersContainer.addRegisterIfNotExists(registerName);
            String operation = tokens[1];
            int operand = Integer.parseInt(tokens[2]);
            String condisionRegisterName = tokens[4];
            registersContainer.addRegisterIfNotExists(condisionRegisterName);
            int conditionRegisterValue = registersContainer.getRegister(condisionRegisterName).getValue();
            String condition = tokens[5];
            int conditionVal = Integer.parseInt(tokens[6]);
            if(Condition.eval(conditionRegisterValue, condition, conditionVal)){
                registersContainer.makeOperation(registerName, operation, operand);
            }
        }

        registersContainer.print();
        System.out.println(registersContainer.findLargestValue());
        System.out.println(registersContainer.getHighestEver());
        System.out.println(registersContainer.getAmount());
    }

}
