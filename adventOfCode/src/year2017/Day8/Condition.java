package year2017.Day8;

public class Condition {

    public static boolean eval(int firstVal, String condition, int secondVal){
        boolean result = false;
        if(condition.equals("==")){
            result = firstVal == secondVal;
        } else if(condition.equals("<=")){
            result = firstVal <= secondVal;
        } else if(condition.equals(">=")){
            result = firstVal >= secondVal;
        } else if(condition.equals("!=")){
            result = firstVal != secondVal;
        } else if(condition.equals("<")){
            result = firstVal < secondVal;
        } else if(condition.equals(">")){
            result = firstVal > secondVal;
        }
        return result;
    }

}
