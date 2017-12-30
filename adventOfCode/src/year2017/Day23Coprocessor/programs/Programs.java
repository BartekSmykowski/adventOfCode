package year2017.Day23Coprocessor.programs;

import java.util.ArrayList;
import java.util.List;

public class Programs {
    private List<Program> programs;
    private boolean allTerminated;

    public Programs(List<String> ordersLines){
        this(2, ordersLines);
    }

    public Programs(int numberOfPrograms, List<String> ordersLines){
        programs = new ArrayList<>();
        for(int i = 0; i < numberOfPrograms; i++){
            programs.add(new Program(i, ordersLines));
        }
        allTerminated = false;
        CommunicationBus.setPrograms(this);
    }

    public void executePrograms(){
        while (!allTerminated) {
            for (Program program : programs) {
                program.executeNextOrder();
            }
            checkAllTermination();
        }
        for (Program program : programs) {
            System.out.println(program.getId() + ": " + program.getSendCounter());
        }
    }

    public void checkAllTermination(){
        boolean allTerminated = true;
        for (Program program : programs){
            if (!program.isStopped())
                allTerminated = false;
        }
        this.allTerminated = allTerminated;
    }

    public List<Program> getPrograms() {
        return programs;
    }
}
