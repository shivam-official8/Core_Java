package Day_4.Collection_Framework_Questions.Lists;

import java.util.ArrayList;
import java.util.HashMap;

public class Frequency_Elements {
    public static void main(String[] args) {
        // it can also be done using array
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(2);
        arr.add(2);
        arr.add(28);
        arr.add(99);
        arr.add(100);
        arr.add(100);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        for(int n: arr)
            hm.put(n, hm.getOrDefault(n,0)+1);

        for(int k: hm.keySet()) System.out.println("Element: "+k+" Frequency: "+hm.get(k));

    }
}
