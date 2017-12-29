package year2017.Day20ParticleSwarm;

import java.util.Comparator;

public class ComparatorByDistance implements Comparator<Particle> {

    @Override
    public int compare(Particle o1, Particle o2) {
        return Integer.compare(o1.distanceFromZero(), o2.distanceFromZero());
    }
}
