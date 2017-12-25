package year2017.Day16;

import java.util.ArrayList;
import java.util.List;

public class Programs {
    private List<Character> programs;
    private List<Integer> offsets;
    private List<Character> firstPrograms;

    public Programs(){
        this(16);
    }

    public Programs(int size){
        programs = new ArrayList<>();
        firstPrograms = new ArrayList<>();
        offsets = new ArrayList<>();
        for(int i = 0; i < size; i++){
            programs.add((char) ((int)'a' + i));
            firstPrograms.add((char) ((int)'a' + i));
        }
    }

    public void makeOrder(String order){
        if(order.charAt(0) == 's'){
            spin(Integer.parseInt(order.substring(1)));
        } else if(order.charAt(0) == 'x'){
            String arguments = order.substring(1);
            String[] aAndB = arguments.split("/");
            exchange(Integer.parseInt(aAndB[0]), Integer.parseInt(aAndB[1]));
        } else if(order.charAt(0) == 'p'){
            String arguments = order.substring(1);
            String[] aAndB = arguments.split("/");
            partner(aAndB[0].charAt(0), aAndB[1].charAt(0));
        }
    }

    public void partner(char a, char b){
        int aIndex = programs.indexOf(a);
        int bIndex = programs.indexOf(b);
        exchange(aIndex, bIndex);
    }

    public void exchange(int a, int b){
        char tmpProgram = programs.get(a);
        programs.set(a, programs.get(b));
        programs.set(b, tmpProgram);
    }

    public void spin(int howMany){
        for(int i = 0; i < howMany;i++){
            spin();
        }
    }

    private void spin(){
        char lastProgram = programs.get(programs.size() - 1);
        for(int i = programs.size() - 1; i >= 1; i--){
            programs.set(i, programs.get(i - 1));
        }
        programs.set(0, lastProgram);
    }

    public List<Character> getPrograms() {
        return programs;
    }

    public List<Character> getFirstPrograms() {
        return firstPrograms;
    }
}
