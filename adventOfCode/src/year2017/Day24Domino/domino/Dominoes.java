package year2017.Day24Domino.domino;

import java.util.ArrayList;
import java.util.List;

public class Dominoes {
    private List<Domino> dominoes;

    public Dominoes(List<String> lines){
        dominoes = new ArrayList<>();
        for(String line:lines){
            dominoes.add(DominoFactory.produce(line));
        }
    }

    public void print(){
        for(Domino domino:dominoes){
            System.out.println(domino + " " + domino.getValue());
        }
    }

    public List<Domino> getDominoes() {
        return dominoes;
    }
}
