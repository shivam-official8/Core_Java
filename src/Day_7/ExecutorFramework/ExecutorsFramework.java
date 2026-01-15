package Day_7.ExecutorFramework;

import java.util.concurrent.*;

public class ExecutorsFramework {

    public static long factorial(int num){
        long mul = 1;
        for(int i=1;i<=num;i++)mul*=i;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mul;
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        // if we are returning anything inside submit then tht lambda function is callable not runnable
        // cause runnable dont return anything
        Future<?> future = executor1.submit(()->22);
        if(future.isDone()){
            System.out.println("future done");
        }
        System.out.println(future.get());

//        for(int i=1;i<10; i++){
//            int finalI = i;
//            executor.submit(()->{
//                long result = factorial(finalI);
//                System.out.println(result);
//            });
////            th
//        }
        executor1.shutdown();
        // like join waits for tht many seconds if complete then next otherwise also next statement
        // it returns boolean
        // Checks: “Are all worker threads done?”
        //
        //If yes → return true
        //
        //If no → block and wait
        //
        //If timeout happens → return false
//        executor.awaitTermination(100, TimeUnit.SECONDS);
        System.out.println("Complete");
    }
}
