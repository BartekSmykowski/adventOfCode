package year2015.Day6;

import util.FilesReader;
import util.GlobalConstatns;
import year2015.Day6.commands.CommandParser;
import year2015.Day6.commands.LightsCommand;

import java.util.ArrayList;
import java.util.List;

public class Day6 {
    public static void main(String[] args) {
        String path = GlobalConstatns.getPath(2015, 6);
        List<String> lines = FilesReader.getLines(path);

        Lights lights = new Lights();
        List<LightsCommand> lightsCommands = new ArrayList<>();

        for(String line:lines){
            lightsCommands.add(CommandParser.parse(lights, line));
        }

        for(LightsCommand command:lightsCommands){
            command.execute();
        }

        System.out.println(lights.getBrightness());
    }
}
