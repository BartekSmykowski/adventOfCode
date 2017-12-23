package year2017.Day10;

import java.util.List;

public class HashListPrinter {
    private KnotHash hashList;

    public HashListPrinter(KnotHash list){
        this.hashList = list;
    }

    public void print(){
        List<Integer> list = hashList.getList();
        list.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    public void printWithMarkedCurrentIndex(){
        List<Integer> list = hashList.getList();
        int currentIndex = hashList.getCurrentIndex();
        for(int i = 0; i < list.size(); i++){
            if(i == currentIndex)
                System.out.print("(");
            System.out.print(list.get(i));
            if(i == currentIndex)
                System.out.print(")");
            System.out.print(" ");
        }
        System.out.println();
    }
}
