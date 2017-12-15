package year2017.Day10;

import util.FilesReader;

import java.util.ArrayList;
import java.util.List;

public class Day10 {

    public static void main(String[] args) {
        String path = "src/year2017/Day10/input.txt";
        List<String> lines = FilesReader.getLines(path);

        List<Integer> lengths = convertToLengths(lines);

        HashList hashList = new HashList(256);
        HashListPrinter hashListPrinter = new HashListPrinter(hashList);
        hashListPrinter.printWithMarkedCurrentIndex();

        for(int i = 0; i <64;i++) {
            for (Integer length : lengths) {
                hashList.doStep(length);
            }
        }

        List<Integer> hashes = new ArrayList<>();
        for(int i = 0; i <16;i++) {
            int hash = hashList.getList().get(i * 16);
            for (int j = 1; j < 16; j++) {
                hash ^= hashList.getList().get(i * 16 + j);
            }
            hashes.add(hash);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int hash:hashes) {
            if(hash < 16){
                stringBuilder.append('0');
            }
            stringBuilder.append(Integer.toHexString(hash));
        }


        System.out.println(stringBuilder.toString());
    }

    private static List<Integer> convertToLengths(List<String> lines) {
        List<Integer> lengths = new ArrayList<>();

        for(String line : lines){
            for(int i = 0; i < line.length(); i++){
                char character = line.charAt(i);
                int ASCIICode = (int)character;
                lengths.add(ASCIICode);
            }
        }
        lengths.add(17);
        lengths.add(31);
        lengths.add(73);
        lengths.add(47);
        lengths.add(23);
        return lengths;
    }


}
