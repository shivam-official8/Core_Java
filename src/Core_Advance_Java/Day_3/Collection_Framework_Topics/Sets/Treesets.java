package Core_Advance_Java.Day_3.Collection_Framework_Topics.Sets;

import java.util.TreeSet;

public class Treesets {
    public static void main(String[] args) {
        TreeSet<Integer> t = new TreeSet<>();
        t.add(3);
        t.add(4);
        t.add(2);
        t.add(-8);
        t.add(99);
        System.out.println(t);
        System.out.println(t.first());
        System.out.println(t.last());
        System.out.println(t.headSet(2));
        System.out.println(t.tailSet(2));
        System.out.println(t.subSet(2,100));
    }
}
