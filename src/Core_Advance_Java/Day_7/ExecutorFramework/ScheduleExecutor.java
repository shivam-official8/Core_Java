package Core_Advance_Java.Day_7.ExecutorFramework;
import java.util.concurrent.*;

public class ScheduleExecutor {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        // runs after 5 seconds delay
//        scheduler.schedule(
//                () -> System.out.println("Task executed after 5 second delay!"),
//                5,
//                TimeUnit.SECONDS
//        );
        // if we want to use fixedrate thenn we have to shutdown it in another schedule
        scheduler.scheduleAtFixedRate(()-> System.out.println("Task executed after every 5 Seconds !"),
                5,
                5,
                TimeUnit.SECONDS);

        // scheduleAtFixedRate runs after every 5 sec wheteher previous task is completed or not if previous task
        // takes 10 sec then also after 5 sec it will add other task in the queue eventhough first task is not
        // completed
        // but in scheduleWithFixedDelay it will delay 5 second after the previous task is completed
        // so it waits for 5 seconds after completing every tasks
        scheduler.scheduleWithFixedDelay(()-> System.out.println("Task executed after every 5 Seconds !"),
                5,
                5,
                TimeUnit.SECONDS);

        scheduler.schedule(()->{
            System.out.println("initiating shutdown...");
            scheduler.shutdown();
        }, 20, TimeUnit.SECONDS);


//        scheduler.shutdown();
    }
}
