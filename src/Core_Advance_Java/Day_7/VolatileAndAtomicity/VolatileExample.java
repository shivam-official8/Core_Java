package Core_Advance_Java.Day_7.VolatileAndAtomicity;

import java.util.concurrent.atomic.AtomicInteger;

class SharedObj {
//    private boolean flag = false;
        private volatile boolean flag = false;
    public void setFlagTrue() {
        System.out.println("Writer Thread made the flag true now!");
        flag = true;
    }

    public void printIfFlagTrue() {
        while (!flag) {
            // do nothing
        }
        System.out.println("Flag is true !");
    }
}

public class VolatileExample {
    public static void main(String[] args) {
      SharedObj sharedObj = new SharedObj();
      Thread writerThread = new Thread(()->{
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
              throw new RuntimeException(e);
          }
          sharedObj.setFlagTrue();
      });
      Thread readerThread = new Thread(()->sharedObj.printIfFlagTrue());
// eventhough after 1 second our writer thread marks the flag true but still we are inside while loop
        // cause every thread has a local copy of variable in there cache for performance reason
        // but if we want thread to not cache a variable and to read and write from main memory then we need
        // to use volatile keyword
      writerThread.start();
      readerThread.start();
    }
}

class VolatileCounter{
    // if we dont want to use locks or synchronized and to overcome writting problem to maintain
    // atomicity then...
//    private volatile int counter = 0;

    // it is thread safe so we can achieve atomicity without locks and synchornized
    private AtomicInteger counter = new AtomicInteger(0);
    public void increment(){
//        this.counter++;
        counter.incrementAndGet();
    }

    public int getCounter(){
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileCounter volatileCounter = new VolatileCounter();
        Thread t1 = new Thread(()->{
            for(int i=0;i<10000;i++){
                volatileCounter.increment();
            }
        });
        Thread t2 = new Thread(()->{
            for(int i=0;i<10000;i++){
                volatileCounter.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(volatileCounter.getCounter());
    }
}