package Core_Advance_Java.Day_6.MultiThreading;

public class Lambda {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        });
        t1.start();

    }
}
