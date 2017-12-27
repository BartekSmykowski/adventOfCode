package year2017.Day19Labirynth;

public enum Sign {
    EMPTY, HORIZONTAL, VERTICAL, CROSS, LETTER, ERROR;

    public static Sign toSign(Character character){
        if(character.equals('-')){
            return HORIZONTAL;
        } else if(character.equals('|')){
            return VERTICAL;
        } else if(character.equals('|')){
            return VERTICAL;
        } else if(character.equals(' ')){
            return EMPTY;
        } else if(character.equals('+')){
            return CROSS;
        } else if(Character.isUpperCase(character)){
            return LETTER;
        } else {
            return ERROR;
        }
    }
}
