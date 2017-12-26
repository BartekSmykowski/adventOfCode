package year2017.Day18.programs;

import java.util.ArrayList;
import java.util.List;

public class Programs {
    private List<Program> programs;

    public Programs(List<String> ordersLines){
        this(2, ordersLines);
    }

    public Programs(int numberOfPrograms, List<String> ordersLines){
        programs = new ArrayList<>();
        for(int i = 0; i < numberOfPrograms; i++){
            programs.add(new Program(i));
        }
        for(Program program:programs){
            for(String line:ordersLines){
                program.parseLine(line);
            }
        }
    }

    public void executePrograms(){

    }

}
