package year2015;

public class Day25 {
    private static int X = 3083;
    private static int Y = 2978;
    //private static int X = 5;
    //private static int Y = 4;
    private static int MULTI = 252533;
    private static int DIVIDE = 33554393;
    private static int FIRST = 20151125;

    public static void main(String[] args) {
        int index = (2-3*Y-X+Y*Y+X*X+2*X*Y)/2;


        long result = FIRST;
        for(int i = 1; i < index; i++){
            result *= MULTI;
            result %= DIVIDE;
        }

        System.out.println(index);
        System.out.println(result);
    }

}
