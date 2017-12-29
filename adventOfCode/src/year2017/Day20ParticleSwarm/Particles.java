package year2017.Day20ParticleSwarm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Particles {

    private List<Particle> particles;
    private List<Particle> closest;

    public Particles(List<String> lines){
        particles = new ArrayList<>();
        for(String line: lines){
            particles.add(parseParticle(line));
        }
        closest = new ArrayList<>(particles);
    }

    private Particle parseParticle(String line) {
        String[] vectorsTokens = line.split(" ");
        Vector3 position = parseVector(vectorsTokens[0]);
        Vector3 velocity = parseVector(vectorsTokens[1]);
        Vector3 acceleration = parseVector(vectorsTokens[2]);
        return new Particle(position, velocity, acceleration);
    }

    private Vector3 parseVector(String vectorToken) {
        String argsToken = vectorToken.substring(3, vectorToken.indexOf('>'));
        String[] argsTokens = argsToken.split(",");
        int x = Integer.parseInt(argsTokens[0]);
        int y = Integer.parseInt(argsTokens[1]);
        int z = Integer.parseInt(argsTokens[2]);
        return new Vector3(x, y, z);
    }

    public void simulate(){
        while(true){
            System.out.println(getNumberOfParticles());
            //sleep(100);
            for(Particle particle : particles){
                particle.nextState();
            }
            removeColliding();
        }
    }

    private void removeColliding() {
        Set<Particle> colliding = new HashSet<>();
        for(Particle particle : particles){
            for(Particle particle2 : particles){
                if(!particle.equals(particle2) && particle.collision(particle2)){
                    colliding.add(particle2);
                    colliding.add(particle);
                }
            }
        }
        particles.removeAll(colliding);
        closest.removeAll(colliding);
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Particle> getSorted(){
        closest.sort(new ComparatorByDistance());
        return closest;
    }

    public int getNumberOfParticles(){
        return particles.size();
    }
}
