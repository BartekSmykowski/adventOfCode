package year2017.Day24Domino.domino;

public class Domino {

    private int left;
    private int right;

    public Domino(int left, int right){
        this.left = left;
        this.right = right;
    }

    public Domino(Domino clone){
        left = clone.left;
        right = clone.right;
    }

    public int getValue(){
        return left+right;
    }

    public boolean isFit(Domino domino){
        return domino.left == left || domino.right == right || domino.left == right || domino.right == left;
    }

    public boolean isFit(Domino domino, int usedPort){
        if(left == right)
            return isFit(domino);
        if(left == usedPort){
            return domino.left == right || domino.right == right;
        }
        if(right == usedPort){
            return domino.left == left || domino.right == left;
        }
        return false;
    }

    public int getFreePort(int used){
        if(left == used)
            return right;
        if(right == used)
            return left;
        return left;
    }

    @Override
    public String toString(){
        return "|" + left + ":" + right + "|";
    }

}
