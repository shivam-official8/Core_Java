package Day_7.Synchronization;

class Counter{
    private int count = 0;
    public synchronized void  increment(){
//        synchronized (this){

        this.count++;
//        }
    }
    public int getCount(){
        return this.count;
    }
}

class MyThread extends Thread{
    private Counter counter;
    public MyThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10000; i++){
            this.counter.increment();
        }
    }
}

public class Synchronization {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
// in some case if counter is at x and both thread increment it together at same time then rather
// then it should be x+2 it will be x+1
        System.out.println(counter.getCount());
    }
}
