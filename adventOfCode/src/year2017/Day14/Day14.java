package year2017.Day14;

import java.util.List;

public class Day14 {

    public static void main(String[] args) {
        String key = "stpzcrnm";
        //String key = "flqrgnkx";


        Disc disc = new Disc(key);

        int counter = 0;
        for (int i = 0; i < disc.getDisc().size();i++){
            List<Boolean> line = disc.getDisc().get(i);
            for (int j = 0; j < line.size(); j++) {
                boolean bit = disc.getDisc().get(i).get(j);
                boolean inRegionBit = disc.getInRegions().get(i).get(j);
                System.out.print(bit?"1":" ");
                System.out.print(inRegionBit?"#":" ");
                if(bit){
                    counter++;
                }
            }
            System.out.println();
        }
        System.out.println(counter);
        System.out.println(disc.getNumberOfRegions());
    }

}
