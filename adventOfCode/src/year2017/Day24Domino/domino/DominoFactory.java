package year2017.Day24Domino.domino;

public class DominoFactory {
    public static Domino produce(String string){
        String[] tokens = string.split("/");
        int left = Integer.parseInt(tokens[0]);
        int right = Integer.parseInt(tokens[1]);
        return new Domino(left, right);
    }
}
