package year2017.Day20ParticleSwarm;

import util.FilesReader;

import java.util.List;

public class Day20 {

    public static void main(String[] args) {
        String filePath = "src/year2017/Day20ParticleSwarm/input.txt";
        List<String> lines = FilesReader.getLines(filePath);

        Particles particles = new Particles(lines);
        particles.simulate();
    }

}
