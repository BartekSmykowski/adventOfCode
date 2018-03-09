package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiniGolfRandom {

    public static List<String> random(List<String> names){
        List<String> tmp = new ArrayList<>(names);
        List<String> result = new ArrayList<>();
        while (!names.isEmpty()) {
            int rand = (int) (Math.random() * (names.size()));
            result.add(names.get(rand));
            names.remove(rand);
        }
        names.addAll(tmp);
        return result;
    }

    public static void randomCourse(){
        System.out.println((int)(Math.random() * 29) + 1);
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("aaa");
        names.add("bbb");
        Map<String, Integer> scores = new HashMap<>();
        for(String name:names){
            scores.put(name, 0);
        }
        for(int j = 0; j < 100; j++) {
            List<String> randomNames = random(names);
            System.out.println(randomNames);
            randomCourse();
        }
    }

}
