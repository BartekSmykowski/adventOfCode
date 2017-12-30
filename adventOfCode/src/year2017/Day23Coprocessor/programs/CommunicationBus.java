package year2017.Day23Coprocessor.programs;

public class CommunicationBus {
    private static CommunicationBus ourInstance = new CommunicationBus();
    private static Programs programs = null;

    public static CommunicationBus getInstance() {
        return ourInstance;
    }

    private CommunicationBus() {
    }

    public static void setPrograms(Programs programs) {
        CommunicationBus.programs = programs;
    }

    public static boolean areProgramsSet(){
        if(programs == null)
            return false;
        else
            return true;
    }

    public static void sendCommunicate(Communicate communicate){
        for(Program program:programs.getPrograms()){
            if(program.getId() !=communicate.getSourceId()){
                program.addToQueue(communicate.getValue());
            }
        }
    }
}
