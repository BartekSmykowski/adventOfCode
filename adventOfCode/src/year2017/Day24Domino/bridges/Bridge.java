package year2017.Day24Domino.bridges;

import year2017.Day24Domino.domino.Domino;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<Domino> dominoList;
    private int lastUsed;

    public Bridge() {
        dominoList = new ArrayList<>();
        dominoList.add(new Domino(0,0));
        lastUsed = 0;
    }

    public Bridge(Bridge copy){
        dominoList = new ArrayList<>(copy.dominoList);
        lastUsed = copy.lastUsed;
    }

    public int getStrenght(){
        int strength = 0;
        for(Domino domino:dominoList){
            strength += domino.getValue();
        }
        return strength;
    }

    public boolean isValidNext(Domino nextDomino){
        return dominoList.get(dominoList.size() - 1).isFit(nextDomino, lastUsed);
    }

    public void addElement(Domino domino){
        if(isValidNext(domino)) {
            lastUsed = dominoList.get(dominoList.size() - 1).getFreePort(lastUsed);
            dominoList.add(domino);
        }
    }

    public void print(){
        for(Domino domino:dominoList){
            System.out.print(domino + "--");
        }
        System.out.println(" " + getStrenght());
    }

    public int size(){
        return dominoList.size();
    }
}
