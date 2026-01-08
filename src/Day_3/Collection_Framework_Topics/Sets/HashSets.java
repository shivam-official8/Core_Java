package Day_3.Collection_Framework_Topics.Sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSets {
    public static void main(String[] args) {
        Set s = new HashSet();
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(1);
        hs.add(2);
        hs.add(3);
        System.out.println(hs.contains(3));
        hs.remove(3);
        System.out.println(hs);

        Iterator<Integer> iterator =hs.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        System.out.println(hs.size());
        System.out.println(hs.remove(1));
        System.out.println(hs);


    }
}
