package year2017.Day18Programs.programs;

import year2017.Day18Programs.orders.Order;
import year2017.Day18Programs.orders.Orders;
import year2017.Day18Programs.orders.SendOrder;
import year2017.Day18Programs.parser.LineParser;
import year2017.Day18Programs.registers.Register;
import year2017.Day18Programs.registers.Registers;

import java.util.LinkedList;
import java.util.Queue;

public class Program {
    private Registers registers;
    private Orders orders;
    private int id;
    private Queue<Long> queue;
    private int currentPosition;
    private boolean stop;
    private int sendCounter;

    public Program(int id){
        this.id = id;
        initRegisters(id);
        orders = new Orders();
        queue = new LinkedList<>();
        currentPosition = 0;
        stop = false;
        sendCounter = 0;
    }

    private void initRegisters(int id) {
        registers = new Registers();
        Register pRegister = new Register('p');
        pRegister.setValue(id);
        registers.addRegister(pRegister);
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
        Order order = orders.getOrder(currentPosition);
        //System.out.println(id + ": " + currentPosition + ": " + order.toString());
        if(order instanceof SendOrder){
            sendCounter++;
        }
        order.execute(this);
        //Printer.printRegisters(registers);
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
}
