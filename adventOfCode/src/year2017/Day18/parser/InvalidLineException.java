package year2017.Day18.parser;

public class InvalidLineException extends RuntimeException {

    public InvalidLineException(String line){
        super(line);
    }

}
