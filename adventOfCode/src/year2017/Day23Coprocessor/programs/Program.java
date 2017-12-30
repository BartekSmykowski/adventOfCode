package year2017.Day23Coprocessor.programs;

import year2017.Day23Coprocessor.Printer;
import year2017.Day23Coprocessor.orders.Order;
import year2017.Day23Coprocessor.orders.Orders;
import year2017.Day23Coprocessor.parser.LineParser;
import year2017.Day23Coprocessor.registers.Register;
import year2017.Day23Coprocessor.registers.Registers;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Program {
    private Registers registers;
    private Orders orders;
    private int id;
    private Queue<Long> queue;
    private int currentPosition;
    private boolean stop;
    private int sendCounter;
    private int mulCounter;

    public Program(int id){
        this.id = id;
        initRegisters(id);
        orders = new Orders();
        queue = new LinkedList<>();
        currentPosition = 0;
        stop = false;
        sendCounter = 0;
        mulCounter = 0;
    }

    public Program(int id, List<String> lines){
        this(id);
        for(String line:lines){
            parseLine(line);
        }
    }

    private void initRegisters(int id) {
        registers = new Registers();
        Register pRegister = new Register('p');
        pRegister.setValue(id);
        registers.addRegister(pRegister);
        Register aRegister = new Register('a');
        aRegister.setValue(1);
        registers.addRegister(aRegister);
    }

    public void parseLine(String line){
        orders.addOrder(LineParser.parseLine(line, this));
    }

    public void executeOrders(){
        while(!stop){
            executeNextOrder();
        }
    }

    public void executeNextOrder(){
        if(currentPosition >= orders.size()) {
            stop = true;
            return;
        }
        Order order = orders.getOrder(currentPosition);
        //System.out.println(id + ": " + currentPosition + ": " + order.toString());
        order.execute(this);
        Printer.printRegisters(registers);
        currentPosition++;
    }

    public void jump(int offset) {
        currentPosition += offset;
    }

    public Registers gerRegisters() {
        return registers;
    }

    public boolean isStopped(){
        return stop;
    }

    public int getId() {
        return id;
    }

    public void addToQueue(long value) {
        queue.add(value);
    }

    public void receiveFromQueue(Character registerName){
        Long value = queue.poll();
        if(value != null){
            registers.getRegister(registerName).setValue(value);
            stop = false;
        } else {
            currentPosition--;
            stop = true;
        }
    }

    public int getSendCounter() {
        return sendCounter;
    }

    public int getMulCounter(){
        return mulCounter;
    }

}
