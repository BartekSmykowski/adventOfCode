package year2017.Day13;

import util.FilesReader;

import java.util.*;

public class Day13 {

    public static void main(String[] args) {
        String path = "src/year2017/Day13/input.txt";
        List<String> lines = FilesReader.getLines(path);

        Map<Integer, Layer> layers = new HashMap<>();

        int max = 0;
        for(String line :lines){
            line = line.replace(":","");
            String[] tokens = line.split(" ");
            int depth = Integer.parseInt(tokens[0]);
            int range = Integer.parseInt(tokens[1]);
            layers.put(depth, new Layer(range, depth));
            if(depth > max)
                max = depth;
        }

        //int severity;
        List<Integer> collided = new ArrayList<>();
        collided.add(0);
        int delay = 0;
        while(!collided.isEmpty()) {
            collided.clear();
            resetLayers(layers);
//
//            if(delay%2 == 1 || delay%4 == 0 || delay%12 == 2 || delay %12 == 10 || delay % 24 == 18 || delay % 120 == 6
//                    || delay % 120 == 102 || delay%120 ==30 || delay%120 == 54 || delay%240 == 78) {
//                collided.add(0);
//                delay++;
//                continue;
//            }

            boolean skip = false;
            for (Layer layer : layers.values()) {
                int period = (layer.getRange()-1)*2;
                if((delay+layer.getDepth())%period == 0) {
                    collided.add(0);
                    delay++;
                    skip = true;
                    break;
                }
            }
            if(skip){
                collided.add(0);
                delay++;
                continue;
            }

            for (int i = 0; i < delay; i++) {
                nextScannerStep(layers);
            }

            for (int i = 0; i <= max; i++) {
                if (layers.containsKey(i) && layers.get(i).isColliding()) {
                    collided.add(i);
                    continue;
                }
                nextScannerStep(layers);
            }
            System.out.println(collided);

            //severity = collided.stream().mapToInt(i -> i * layers.get(i).getRange()).sum();
            System.out.println(delay);
            delay++;
        }
        delay--;
        System.out.println(delay);
    }

    private static void nextScannerStep(Map<Integer, Layer> layers) {
        for (Layer layer : layers.values()) {
            layer.nextStep();
        }
    }

    private static void resetLayers(Map<Integer, Layer> layers) {
        for (Layer layer : layers.values()) {
            layer.reset();
        }
    }

}
