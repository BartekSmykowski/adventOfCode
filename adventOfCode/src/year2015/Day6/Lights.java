package year2015.Day6;

import java.util.ArrayList;
import java.util.List;

public class Lights {
    private List<List<Light>> lights;

    public Lights(){
        this(1000);
    }

    public Lights(int size){
        lights = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            List<Light> row = new ArrayList<>();
            for(int j = 0; j < size; j++){
                row.add(new Light());
            }
            lights.add(row);
        }
    }

    public int getBrightness(){
        int sum = 0;
        for(List<Light> row:lights){
            for(Light light:row){
                sum+=light.getBrightness();
            }
        }
        return sum;
    }

    public Light getLight(Point point){
        return lights.get(point.getX()).get(point.getY());
    }

    public void turnOn(Point point){
        getLight(point).turnOn();
    }

    public void turnOff(Point point){
        getLight(point).turnOff();
    }

    public void toggle(Point point){
        getLight(point).toggle();
    }

}
