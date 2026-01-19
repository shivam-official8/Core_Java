package Core_Advance_Java.Day_4.Collection_Framework_Questions.Sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Difference {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        TreeSet<Integer> ts = new TreeSet<>();
        hs.add(1);
        hs.add(1);
        hs.add(-1);
        hs.add(-2);
        hs.add(-1);
        hs.add(90);
        hs.add(99);
        hs.add(99);
        hs.add(99);
        hs.add(111);
        hs.add(-2);
        lhs.add(1);
        lhs.add(1);
        lhs.add(-1);
        lhs.add(-2);
        lhs.add(-1);
        lhs.add(90);
        lhs.add(99);
        lhs.add(99);
        lhs.add(99);
        lhs.add(111);
        lhs.add(-2);
        ts.add(1);
        ts.add(1);
        ts.add(-1);
        ts.add(-2);
        ts.add(-1);
        ts.add(90);
        ts.add(99);
        ts.add(99);
        ts.add(99);
        ts.add(111);
        ts.add(-2);
        // unordered set
        System.out.println(hs);
        // ordered set
        System.out.println(lhs);
        // sorted set
        System.out.println(ts);
    }
}
