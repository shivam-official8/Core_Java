package Day_6.MultiThreading;

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
//            System.out.println(this.isAlive());
            try {
//            this.join();
                Thread.yield();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        Runnable r  = ()->{
            for (int i = 1; i <= 5; i++) {
                System.out.println("Runnable "+Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
//        t1.setPriority(10);
        t1.start();
//        try{
//            t1.notifyAll();
//        }catch(Exception e){
////            System.out.println(e.getLocalizedMessage());
//        }
//        t1.join();
        System.out.println(t1.isAlive());
        Thread t2 = new Thread(r);
        t2.start();
    }
}

