package year2017.Day9.entities;

public abstract class Entity implements CharProcessor {
    protected StringBuilder allSigns;
    protected boolean ignoreNext;
    protected boolean isEnded;
    protected Entity parent;

    public Entity(Entity parent){
        ignoreNext = false;
        isEnded = false;
        allSigns = new StringBuilder();
        this.parent = parent;
    }

    public boolean isEnded(){
        return isEnded;
    }

    public Entity parent(){
        return parent;
    }

    public String getAsString(){
        return allSigns.toString();
    }
}
