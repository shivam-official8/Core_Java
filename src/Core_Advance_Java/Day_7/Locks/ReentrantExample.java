package Core_Advance_Java.Day_7.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {

    private final Lock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock();
        try {
            System.out.println(" : Outer method");
            innerMethod();
        } finally {
            System.out.println("Dead Lock");
            lock.unlock();
        }
    }

    public void innerMethod() {
        lock.lock(); // Dead Lock
        try {
            System.out.println(" : Inner method");
        } finally {
            lock.unlock();
        }
    }
}
 class Main1 {
    public static void main(String[] args) {

        ReentrantExample example = new ReentrantExample();

//        Runnable task = () -> example.outerMethod();
//
//        Thread t1 = new Thread(task, "Thread-1");
//        Thread t2 = new Thread(task, "Thread-2");
//
//        t1.start();
//        t2.start();

        example.outerMethod();
    }
}


