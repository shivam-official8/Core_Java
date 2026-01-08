package Day_3.Collection_Framework_Topics.Sets;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashsets {
    public static void main(String[] args) {
        HashSet<Integer> hs = new LinkedHashSet<>();
        hs.add(2);
        hs.add(3);
        hs.add(1);
        hs.add(4);
        System.out.println(hs);
    }
}
