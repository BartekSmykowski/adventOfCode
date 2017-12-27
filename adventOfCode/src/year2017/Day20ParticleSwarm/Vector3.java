package year2017.Day20ParticleSwarm;

public class Vector3 {
    private int x;
    private int y;
    private int z;

    public Vector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void add(Vector3 vector){
        this.x += vector.x;
        this.y += vector.y;
        this.z += vector.z;
    }

    public boolean equals(Vector3 vector){
        if(vector.x == x && vector.y == y && vector.z == z)
            return true;
        else
            return false;
    }

    @Override
    public String toString(){
        return x + " " + y + " " + z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
