package year2017.Day17;

public class Day17 {

    public static void main(String[] args) {
        int skipRange = 314;
        //int skipRange = 3;

        SpinlockList list = new SpinlockList(skipRange);
        //System.out.println(list.getList());

        for(int number:list.getList()){
            if(number == 0) {
                System.out.println(number);
                System.out.println(list.getAfter0());
            }
        }

    }

}
