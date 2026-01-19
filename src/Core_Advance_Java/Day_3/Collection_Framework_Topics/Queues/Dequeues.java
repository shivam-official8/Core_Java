package Core_Advance_Java.Day_3.Collection_Framework_Topics.Queues;

import java.util.Deque;
import java.util.LinkedList;

public class Dequeues {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.offer(2);
        dq.offerFirst(1);
        dq.offerLast(5);
        dq.offerFirst(65);
        dq.offerLast(23);
        System.out.println(dq.peek());
        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());
        System.out.println(dq.pollFirst());
        System.out.println(dq.pollLast());
        System.out.println(dq.poll());
    }
}
