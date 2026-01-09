package Day_4.Collection_Framework_Questions;

import java.util.HashMap;
import java.util.Map;

public class Merge_maps {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 10);
        map1.put("B", 20);
        map1.put("C", 30);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 5);
        map2.put("C", 15);
        map2.put("D", 25);
        map2.put("F", 25);

        for(String k: map1.keySet()){
            if(map2.containsKey(k))map2.put(k, map2.get(k)+map1.get(k));
            else map2.put(k, map1.get(k));
        }
        System.out.println(map2);


    }
}
