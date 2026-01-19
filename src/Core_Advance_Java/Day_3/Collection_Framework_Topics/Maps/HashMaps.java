package Core_Advance_Java.Day_3.Collection_Framework_Topics.Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMaps {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "hello 1");
        map.put(2, "hello 2");
        map.put(3, "hello 3");
        map.put(4, "hello 4");
        map.put(5, "hello 5");
//        System.out.println(map.get(1));
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            System.out.println(map.get(iterator.next()));
        }
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(6, "hii 1");
        map1.put(2, "hii 1");
        map1.put(7, "hii 1");
        map1.put(8, "hii 1");
        map1.put(9, "hii 1");
        map.putAll(map1);
        System.out.println(map);
        System.out.println(map1);

        map.remove(1);
        System.out.println(map);
        map.compute(3, (k, v)->v+"------------");
        System.out.println(map);
    }
}
