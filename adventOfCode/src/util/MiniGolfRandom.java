package util;

import java.util.ArrayList;
import java.util.List;

public class MiniGolfRandom {

    public static void random(){
        for(int i = 0; i < 100; i++) {
            List<String> names = new ArrayList<>();
            names.add("Ignacy");
            names.add("Stachu");
            names.add("Bartek");
            names.add("Jozio");
            while (!names.isEmpty()) {
                int rand = (int) (Math.random() * (names.size()));
                System.out.print(names.get(rand) + " ");
                names.remove(rand);
            }
            System.out.println();
        }
    }

}
