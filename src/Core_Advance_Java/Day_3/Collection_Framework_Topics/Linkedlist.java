package Core_Advance_Java.Day_3.Collection_Framework_Topics;

import java.util.LinkedList;

public class Linkedlist {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(2);
        l.add(1);
        l.add(4);
        l.add(3);
        System.out.println(l.getFirst());
        System.out.println(l.getLast());
        System.out.println(l.get(2));
        System.out.println(l);
        l.sort((a,b)->b-a);
        System.out.println(l);
    }
}
