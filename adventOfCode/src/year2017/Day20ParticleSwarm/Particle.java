package year2017.Day20ParticleSwarm;

public class Particle {
    private Vector3 position;
    private Vector3 velocity;
    private Vector3 acceleration;
    private int id;
    private static int ID;

    public Particle(Vector3 position, Vector3 velocity, Vector3 acceleration) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
        id = ID;
        ID++;
    }

    public void nextState(){
        velocity.add(acceleration);
        position.add(velocity);
    }

    public int distanceFromZero(){
        return Math.abs(position.getX()) + Math.abs(position.getY()) + Math.abs(position.getZ());
    }

    public boolean collision(Particle particle){
        if(particle.position.equals(position))
            return true;
        else
            return false;
    }

    @Override
    public String toString(){
        return "id: " + id + ", distance = " + distanceFromZero() + ", p = " + position.toString() + ", v = " + velocity.toString() + ", a = " + acceleration.toString();
    }

    public int getId() {
        return id;
    }
}
