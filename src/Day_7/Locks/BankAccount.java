package Day_7.Locks;



import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance = 1000;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName()
                + " attempting to withdraw " + amount);

        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    if (balance >= amount) {
                        System.out.println(Thread.currentThread().getName()
                                + " proceeding with withdrawal");

                        Thread.sleep(3000); // simulate processing time
                        balance -= amount;

                        System.out.println(Thread.currentThread().getName()
                                + " completed withdrawal. Remaining balance: " + balance);
                    } else {
                        System.out.println(Thread.currentThread().getName()
                                + " insufficient balance");
                    }
                } catch (Exception e) {
                    Thread.currentThread().interrupt(); // good practice
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " could not acquire the lock");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // good practice
        }
        // now we can do
        if (Thread.currentThread().isInterrupted()) {
            System.out.println("Some action, Thread is interrupted!");
        }
    }
}



class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Runnable task = () -> account.withdraw(700);

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}


