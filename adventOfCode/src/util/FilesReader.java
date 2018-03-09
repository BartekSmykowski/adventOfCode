package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesReader {

    public static Path loadFile(String path){
        Path file = null;
        try{
            file = Paths.get(path);
        }catch (Exception e){
            e.printStackTrace();
        }
        return file;

    }

    public static List<String> tryReadLines(Path file) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<String> getLines(String path){
        Path file = loadFile(path);
        return tryReadLines(file);
    }
}
