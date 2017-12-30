package year2017.Day23Coprocessor.programs;

public class Communicate {
    private long value;
    private int sourceId;

    public Communicate(long value, int sourceId) {
        this.value = value;
        this.sourceId = sourceId;
    }

    public long getValue() {
        return value;
    }

    public int getSourceId() {
        return sourceId;
    }
}
