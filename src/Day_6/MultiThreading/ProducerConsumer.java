package Day_6.MultiThreading;


 class PizzaBuffer {

    private int pizzaCnt;
    private boolean available = false;

    public synchronized void produce(int num) throws InterruptedException {
        while (available) {
            wait();
        }
        this.pizzaCnt = num;
        available = true;
        notify();
    }

    public synchronized int consume() throws InterruptedException {
        while (!available) {
            wait();
        }
        available = false;
        notify();
        return pizzaCnt;
    }
}

class Producer implements Runnable {

    private PizzaBuffer buffer;

    public Producer(PizzaBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
//            String[] messages = {"Hi", "Hello", "Bye"};
            for (int i = 0; i < 10; i++) {
                buffer.produce(i);
                System.out.println("Produced pizza: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {

    private PizzaBuffer buffer;

    public Consumer(PizzaBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int cnt = buffer.consume();
                System.out.println("Consumed pizza: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




public class ProducerConsumer {
    public static void main(String[] args) {
        PizzaBuffer pbuff = new PizzaBuffer();
        Thread producer = new Thread(new Producer(pbuff));
        Thread consumer = new Thread(new Consumer(pbuff));

        producer
                .start();
        consumer.start();
    }
}
