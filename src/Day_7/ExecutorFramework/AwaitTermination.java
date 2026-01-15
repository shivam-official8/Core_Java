package Day_7.ExecutorFramework;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AwaitTermination {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService e = Executors.newSingleThreadExecutor();
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(()->{
            System.out.println("Task 1");
        });
        es.submit(()->{
            System.out.println("Task 2");
        });

        es.submit(()->{
            System.out.println("Task  3");
        });

es.shutdown();
        es.awaitTermination(5, TimeUnit.SECONDS);
//        es.submit(()->{
//            System.out.println("Task 4");
//
//        });
//
//        es.submit(()->{
//            System.out.println("Task 5");
//
//        });
//        es.submit(()->{
//            System.out.println("Task 6");
//
//        });



    }
}
