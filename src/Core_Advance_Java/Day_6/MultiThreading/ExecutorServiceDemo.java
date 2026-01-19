package Core_Advance_Java.Day_6.MultiThreading;
// Using ExecutorService
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
                ExecutorService threads = Executors.newFixedThreadPool(2);
                threads.submit(() -> {
                    System.out.println("Task 1 is running in " + Thread.currentThread().getName());
                });

                threads.submit(() -> {
                    System.out.println("Task 2 is running in " + Thread.currentThread().getName());
                });
                threads.shutdown();
    }
}
