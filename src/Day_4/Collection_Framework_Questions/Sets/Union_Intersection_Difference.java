package Day_4.Collection_Framework_Questions.Sets;

import java.util.HashSet;

public class Union_Intersection_Difference {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
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

        HashSet<Integer> hs1 = new HashSet<>();
        hs1.add(1);
        hs1.add(1);
        hs1.add(-1);
        hs1.add(-2);
        hs1.add(-11);
        hs1.add(90);
        hs1.add(99);
        hs1.add(90);
        hs1.add(99);
        HashSet<Integer> intersection = (HashSet<Integer>) (hs.clone());
        HashSet<Integer> union = (HashSet<Integer>) (hs.clone());
        HashSet<Integer> diff = (HashSet<Integer>) (hs.clone());
//        hs.add(111);
//        hs.add(-2);
        union.addAll(hs1);
        diff.removeAll(hs1);
        intersection.retainAll(hs1);
        System.out.println("intersection: "+intersection);
        System.out.println("union: "+ union);
        System.out.println("difference: "+ diff);
    }
}
