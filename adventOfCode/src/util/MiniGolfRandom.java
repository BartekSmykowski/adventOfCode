package util;

import java.util.ArrayList;
import java.util.List;

public class MiniGolfRandom {

    public static void random(){
        for(int i = 0; i < 1; i++) {
            List<String> names = new ArrayList<>();
            List<Integer> scores = new ArrayList<>();
            names.add("Marycha");
            names.add("Stachu");
            names.add("Bartek");
            names.add("Mati");
            while (!names.isEmpty()) {
                int rand = (int) (Math.random() * (names.size()));
                System.out.print(names.get(rand) + " ");
                names.remove(rand);
            }
            System.out.println();
        }
    }

    public static void randomCourse(){
        System.out.println((int)(Math.random() * 29) + 1);
    }

    public static void main(String[] args) {
        random();
        randomCourse();
    }

}
