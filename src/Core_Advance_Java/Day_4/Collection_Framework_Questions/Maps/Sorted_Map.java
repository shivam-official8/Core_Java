package Core_Advance_Java.Day_4.Collection_Framework_Questions.Maps;

import java.util.Map;
import java.util.TreeMap;

public class Sorted_Map {
    public static void main(String[] args) {
        Map<String, Integer> hm= new TreeMap<>();
        hm.put("ab", 89);
        hm.put("ba", 234);
        hm.put("fb", -24);
        hm.put("hj", 23);
        hm.put("sdf", 11);
        System.out.println(hm);
    }
}
