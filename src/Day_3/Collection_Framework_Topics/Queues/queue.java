package Day_3.Collection_Framework_Topics.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class queue {
    public static void main(String[] args) {
        Queue<Integer> q= new LinkedList<>();
        System.out.println(q.offer(1));
        System.out.println(q.add(1));
        q.offer(2);
        System.out.println(q.poll());
        System.out.println(q.remove());
        System.out.println(q.remove(2));
        System.out.println(q.peek());
    }
}
