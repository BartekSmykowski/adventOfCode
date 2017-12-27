package year2017.Day18Programs.parser;

public class InvalidLineException extends RuntimeException {

    public InvalidLineException(String line){
        super(line);
    }

}
