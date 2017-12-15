package year2017.Day9.entities;

public class Garbage extends Entity {
    private int numberOfLetters;

    public Garbage(Entity parent){
        super(parent);
        allSigns.append('<');
        numberOfLetters = 0;
    }

    @Override
    public void processChar(char character) {
        allSigns.append(character);
        if(ignoreNext){
            ignoreNext = false;
            return;
        }
        if(character == '!'){
            ignoreNext = true;
        } else if(character == '>'){
            isEnded = true;
        } else {
            numberOfLetters++;
        }
    }

    public int getNumberOfLetters(){
        return numberOfLetters;
    }
}
