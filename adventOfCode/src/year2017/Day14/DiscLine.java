package year2017.Day14;

import java.util.ArrayList;
import java.util.List;

public class DiscLine {

    private int length;
    private String hash;
    private List<Boolean> bits;

    public DiscLine(String hash){
        this(128, hash);
    }

    public DiscLine(int length, String hash){
        this.length = length;
        this.hash = hash;
        bits = new ArrayList<>(length);
        for(char sign: hash.toCharArray()){
            List<Boolean> charBits = getCharBits(sign);
            bits.addAll(charBits);
        }
    }

    private List<Boolean> getCharBits(char sign) {
        String bitsString = "0000";
        if(sign == '0'){
            bitsString = "0000";
        } else if(sign == '1'){
            bitsString = "0001";
        } else if(sign == '2'){
            bitsString = "0010";
        } else if(sign == '3'){
            bitsString = "0011";
        } else if(sign == '4'){
            bitsString = "0100";
        } else if(sign == '5'){
            bitsString = "0101";
        } else if(sign == '6'){
            bitsString = "0110";
        } else if(sign == '7'){
            bitsString = "0111";
        } else if(sign == '8'){
            bitsString = "1000";
        } else if(sign == '9'){
            bitsString = "1001";
        } else if(sign == 'a'){
            bitsString = "1010";
        } else if(sign == 'b'){
            bitsString = "1011";
        } else if(sign == 'c'){
            bitsString = "1100";
        } else if(sign == 'd'){
            bitsString = "1101";
        } else if(sign == 'e'){
            bitsString = "1110";
        } else if(sign == 'f'){
            bitsString = "1111";
        }

        List<Boolean> charBits = new ArrayList<>();
        for(char bit:bitsString.toCharArray()){
            if(bit =='0')
                charBits.add(false);
            else if(bit == '1')
                charBits.add(true);
        }
        return charBits;
    }


    public List<Boolean> getBits() {
        return bits;
    }
}
