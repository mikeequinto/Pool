package command;

import javax.swing.text.StyledEditorKit;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CalculationManager {

    static CalculatorFactory cf = new CalculatorFactory();

    static private BlockingQueue<Command> queue = new ArrayBlockingQueue(100);

    static private boolean enabled = false;

    public static void main(String[] args) throws InterruptedException {

        Command c1 = new Command(CommandType.ADD, 5, 6);
        Command c2 = new Command(CommandType.MULT, 7, 8);
        queue.add(c1);
        queue.add(c2);

        Thread tAjout = new Thread(new Runnable(){
            @Override
            public void run(){

                while(enabled){
                    try{
                        Command c = new Command(CommandType.MULT, 2, 6);
                        queue.add(c);
                        Thread.sleep(1000);

                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){

                int counter = 0;
                while(enabled){
                    counter++;
                    try{
                        Command command = queue.take();
                        System.out.println(counter + " " + execCommand(command));
                        Thread.sleep(100);

                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }

            }
        });

        enabled = true;
        tAjout.start();
        t1.start(); 

        Thread.sleep(10000);
        enabled = false;
        System.out.println("End");

    }

    static private Integer execCommand(Command command){
        AbstractCalculator calculator = cf.create(command.getOperation());
        return calculator.calculate(command.getArg1(), command.getArg2());
    }

}
