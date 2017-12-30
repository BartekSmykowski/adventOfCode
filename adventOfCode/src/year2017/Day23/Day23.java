package year2017.Day23;

public class Day23 {

    public static void main(String[] args) {
        program2();
    }

    public static void program(){
        long a = 1;
        long b = 108100;
        long c = 125100;
        long d = 2;
        long e = 2;
        long f = 1;
        long g = 0;
        long h = 0;

        while(true) {
            f = 1;
            d = 2;
            do {
                e = 2;
                do {
                    g = d * e - 108100;
                    if (g == 0)
                        f = 0;
                    e++;
                    g = e - 108100;
                } while (g != 0);
                d++;
                g = d - 108100;
            } while (g != 0);

            if (f == 0)
                h++;
            g = b - c;
            if (g == 0) {
                System.out.println(h);
                return;
            }
            b += 17;
            System.out.println(g);
        }

    }

    public static void program2(){
        long b = 108100;
        long h = 0;

        long time = System.currentTimeMillis();

        while(true) {
            boolean prime = isPrime(b);
            System.out.println(b + ": " + prime + " " + (System.currentTimeMillis() - time));
            if (!prime)
                h++;
            if (b == 125100) {
                System.out.println(h);
                return;
            }
            b += 17;
        }
    }

    private static boolean isPrime(long number){
        long divider = 2;
        while(divider < number){
            if(number%divider == 0)
                return false;
            divider++;
        }
        return true;
    }
}
