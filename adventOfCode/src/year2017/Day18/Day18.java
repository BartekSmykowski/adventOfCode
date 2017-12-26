package year2017.Day18;

import util.FilesReader;
import year2017.Day18.orders.Orders;
import year2017.Day18.parser.LineParser;
import year2017.Day18.registers.Registers;

import java.util.List;

public class Day18 {

    public static void main(String[] args) {
        String path = "src/year2017/Day18/input.txt";
        List<String> lines = FilesReader.getLines(path);

        Registers registers = new Registers();
        Orders orders = new Orders();

        for(String line:lines){
            LineParser.parseLine(line, registers, orders);
        }

        orders.executeOrders(registers);
    }

}
