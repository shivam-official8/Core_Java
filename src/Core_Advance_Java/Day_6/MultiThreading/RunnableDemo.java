package Core_Advance_Java.Day_6.MultiThreading;

class MyRunnable implements Runnable {
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
    public void start(){
        System.out.println("Start method..");
    }
}

public class RunnableDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable());
        System.out.println("Main: "+Thread.currentThread().getState());
        System.out.println(t1.getState());
//        System.out.println(t1.getState());
        t1.start();
        Thread.sleep(100);
        t1.interrupt();
        System.out.println(t1.getState());
        System.out.println("Main: "+Thread.currentThread().getState());

        t1.join();
        System.out.println(t1.getState());
        System.out.println("Main: "+Thread.currentThread().getState());


    }
}

