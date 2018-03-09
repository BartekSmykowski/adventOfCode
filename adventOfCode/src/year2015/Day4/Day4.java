package year2015.Day4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {

    public static void main(String[] args) {
        String input = "ckczppom";

        int index = 0;
        String hash = "";
        while(!hasZerosAtBeginning(hash)) {
            MessageDigest messageDigest = getMessageDigest();
            byte[] hashBytes = messageDigest.digest((input + index).getBytes());
            hash = bytesToHex(hashBytes);
            if(index%1000 == 0){
                System.out.println(index);
            }
            index++;
        }
        index--;
        System.out.print(index);

    }

    private static boolean hasZerosAtBeginning(String hash) {
        if(hash.length() < 6)
            return false;
        for(int i = 0; i < 6; i++)
            if(hash.charAt(i) != '0')
                return false;
        return true;
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    private static MessageDigest getMessageDigest() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
