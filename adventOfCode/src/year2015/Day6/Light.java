package year2015.Day6;

public class Light {
    private int brightness;

    public Light(){
        this.brightness = 0;
    }

    public void turnOn(){
        brightness++;
    }

    public void turnOff(){
        if(brightness > 0) {
            brightness--;
        }
    }

    public void toggle(){
        brightness+=2;
    }

    public int getBrightness(){
        return brightness;
    }

}
