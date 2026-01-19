package Core_Advance_Java.Day_5.LambdaExpression;

import java.util.ArrayList;
import java.util.List;

public class VariableCapturing {
    private int number = 10;

    private static int counter = 5;

    void increment(){

        Runnable r = () -> {
            counter++;
            System.out.println("Counter: " + counter);
        };
        r.run();
    }

    void display(){

        Runnable r = () -> {
            System.out.println("Instance variable: " + number);
        };
        r.run();
    }

    void show(){

        int num = 20;

        Runnable r = () ->{
            System.out.println("Local variable captured: " + num);
        };

        r.run();
    }


    public static void main(String[] args) {
        new VariableCapturing().display();
        new VariableCapturing().increment();
        new VariableCapturing().show();

        // Why Lambdas Require Final or Effectively Final Variables
        //Lambda expression can outlive their defining method.
        // To ensure consistency, they can capture only local variables that are final or effectively final,
        // guaranteeing predictable, unchanging values.

        List<Runnable> tasks = new ArrayList<>();

        for (int i=0;i<3;i++){
            int temp = i;
            tasks.add(() -> System.out.println("Value: " + temp));
        }

        tasks.forEach(Runnable::run);

        Runnable myThread = ()->{ // block lambda expression
            Thread.currentThread().setName("myThread");
            System.out.println(
                    Thread.currentThread().getName()
                            + " is running");
        };
        Thread run = new Thread(myThread);
        run.start();

    }
}
