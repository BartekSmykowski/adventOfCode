package year2015.Day3;

public class Santa {
    private Point position;

    public Santa(){
        position = new Point();
    }

    public Santa(Point startPosition){
        position = startPosition;
    }

    public void move(Direction direction){
        position.move(direction);
    }

    public Point getPosition(){
        return position;
    }
}
