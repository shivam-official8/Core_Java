package Day_4.Collection_Framework_Questions.Sets;

import java.util.HashSet;
import java.util.TreeSet;

public class Sort_Set {
    public static void main(String[] args) {
        TreeSet<Integer> hs = new TreeSet<>();
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
        System.out.println(hs);
    }
}
