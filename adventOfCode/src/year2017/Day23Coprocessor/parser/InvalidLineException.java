package year2017.Day23Coprocessor.parser;

public class InvalidLineException extends RuntimeException {

    public InvalidLineException(String line){
        super(line);
    }

}
