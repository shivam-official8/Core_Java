package Day_3.Collection_Framework_Topics.Queues;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueues {
    public static void main(String[] args) {
        Queue<Integer> minheap = new PriorityQueue<>();
        Queue<Integer> maxheap = new PriorityQueue<>((a,b)->b-a);
        minheap.offer(99);
        minheap.offer(3);
        minheap.offer(990);
        minheap.offer(6);
        minheap.offer(1);
        System.out.println(minheap);
        maxheap.offer(2);
        maxheap.offer(77);
        maxheap.offer(1);
        maxheap.offer(90);
        maxheap.offer(9999);
        System.out.println(maxheap);
    }
}
