package Core_Advance_Java.Day_5.LambdaExpression;

public class CreateThreads {
    public static void main(String[] args) {

        Runnable myThread = ()->{
            Thread.currentThread().setName("myThread");
            System.out.println(
                    Thread.currentThread().getName()
                            + " is running");
        };
        Thread run = new Thread(myThread);
//        Thread run1 = new Thread(myThread); // multi threading
        run.start();
//        run1.start();
    }
}
