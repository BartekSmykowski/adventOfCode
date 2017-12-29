package year2017.Day15;

public class Day15 {

    public static void main(String[] args) {

        Generator A = new Generator(516, 16807, 4);
        Generator B = new Generator(190, 48271, 8);
//        Generator A = new Generator(65, 16807, 4);
//        Generator B = new Generator(8921, 48271, 8);
        int counter = 0;
        for(int i = 0; i < 5000000; i++){
            A.nextValid();
            B.nextValid();
            long aValue = A.get16BitsValue();
            long bValue = B.get16BitsValue();
            //System.out.println(i + ": " + A.getValue() + " " + B.getValue() + " " + aValue + " " + bValue);
            if(aValue == bValue)
                counter++;
        }
        System.out.println(counter);
    }

}
