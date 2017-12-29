package year2017.Day10;

import java.util.ArrayList;
import java.util.List;

public class KnotHash {
    private List<Integer> list;
    private int currentIndex;
    private int skip;
    private int size;
    private List<Integer> hashes;
    private String result;

    public KnotHash(){
        this(256);
    }

    public KnotHash(int size){
        this.size = size;
        list = new ArrayList<>(size);
        hashes = new ArrayList<>();
        resetHash();
        skip = 0;
    }

    private void resetHash() {
        list.clear();
        for(int i = 0; i < size; i++){
            list.add(i);
        }
        currentIndex = 0;
        hashes.clear();
        skip = 0;
    }

    public void doStep(int length){
        for(int i = 0; i < length/2; i++){
            int index = (currentIndex + length - i - 1) % list.size();
            int index2 = (currentIndex + i)%list.size();
            int tmp = list.get(index);
            int tmp2 = list.get(index2);
            list.set(index, tmp2);
            list.set(index2, tmp);
        }
        currentIndex += skip;
        currentIndex += length;
        currentIndex %= list.size();
        skip++;
    }

    public void doSteps(List<Integer> lengths){
        for(int length : lengths){
            doStep(length);
        }
    }

    public String knotHash(String key){
        resetHash();
        List<Integer> lengths = convertToLengths(key);
        for(int i = 0; i <64;i++) {
            doSteps(lengths);
        }
        for(int i = 0; i <16;i++) {
            int hash = list.get(i * 16);
            for (int j = 1; j < 16; j++) {
                hash ^= list.get(i * 16 + j);
            }
            hashes.add(hash);
        }

        makeResultString();
        return result;
    }

    private void makeResultString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int hash:hashes) {
            if(hash < 16){
                stringBuilder.append('0');
            }
            stringBuilder.append(Integer.toHexString(hash));
        }
        result = stringBuilder.toString();
    }

    private static List<Integer> convertToLengths(String key) {
        List<Integer> lengths = new ArrayList<>();

        for(int i = 0; i < key.length(); i++){
            char character = key.charAt(i);
            int ASCIICode = (int)character;
            lengths.add(ASCIICode);
        }
        lengths.add(17);
        lengths.add(31);
        lengths.add(73);
        lengths.add(47);
        lengths.add(23);
        return lengths;
    }

    public List<Integer> getList(){
        return list;
    }

    public int get(int index){
        return list.get(index);
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public List<Integer> getHashes() {
        return hashes;
    }

    public String getResult() {
        return result;
    }
}
