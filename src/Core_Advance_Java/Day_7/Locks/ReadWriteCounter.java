package Core_Advance_Java.Day_7.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    private void increment(){
        writeLock.lock();
        try{
        this.count++;
        }finally {
            writeLock.unlock();
        }
    }
    private int getCount(){
        readLock.lock();
        try{
        return this.count;
        }
        finally {
            readLock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException{

        ReadWriteCounter counter = new ReadWriteCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    System.out.println(Thread.currentThread().getName()+" read: "+counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10;i++){
                    System.out.println(Thread.currentThread().getName()+" incremented");
                    counter.increment();
                }
            }
        };

        Thread writeThread = new Thread(writeTask);
        Thread readThread1 = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);

        writeThread.start();
        readThread1.start();
        readThread2.start();

        writeThread.join();
        readThread1.join();
        readThread2.join();



    }
}
