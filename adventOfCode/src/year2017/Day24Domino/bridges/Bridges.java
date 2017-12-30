package year2017.Day24Domino.bridges;

import year2017.Day24Domino.domino.Domino;
import year2017.Day24Domino.domino.Dominoes;

import java.util.ArrayList;
import java.util.List;

public class Bridges {
    private List<Bridge> bridges;
    private Dominoes dominoes;


    public Bridges(Dominoes dominoes){
        this.dominoes = dominoes;
        generateBridges();
    }

    private void generateBridges() {
        bridges = new ArrayList<>();
        generateBridges(dominoes.getDominoes(), new Bridge());
    }

    private void generateBridges(List<Domino> possibleDominoes, Bridge baseBridge){
        for(Domino domino:possibleDominoes){
            if(baseBridge.isValidNext(domino)){
                List<Domino> leftDominoes = new ArrayList<>(possibleDominoes);
                leftDominoes.remove(domino);
                Bridge newBridge = new Bridge(baseBridge);
                newBridge.addElement(domino);
                bridges.add(newBridge);
                generateBridges(leftDominoes, newBridge);
            }
        }
    }

    public int getStrongest(){
        int max = 0;
        for(Bridge bridge:bridges){
            if(bridge.getStrenght() > max)
                max = bridge.getStrenght();
        }
        return max;
    }

    public int getMaxSize(){
        int max = 0;
        for(Bridge bridge:bridges){
            if(bridge.size() > max)
                max = bridge.size();
        }
        return max;
    }

    public int getStrenghtOfLongest(){
        int max = 0;
        int length = getMaxSize();
        for(Bridge bridge:bridges){
            if(bridge.size() == length && bridge.getStrenght() > max) {
                max = bridge.getStrenght();
            }
        }
        return max;
    }

    public void print(){
        for(Bridge bridge : bridges){
            bridge.print();
        }
    }

    public List<Bridge> getBridges() {
        return bridges;
    }
}
