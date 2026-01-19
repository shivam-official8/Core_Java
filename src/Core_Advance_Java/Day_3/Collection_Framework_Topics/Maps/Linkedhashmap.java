package Core_Advance_Java.Day_3.Collection_Framework_Topics.Maps;

import java.util.LinkedHashMap;
import java.util.Map;

public class Linkedhashmap {
    public static void main(String[] args) {
        Map<Integer, String> lhm = new LinkedHashMap<>();
        lhm.put(1, "jcnken");;
        lhm.put(4, "ved");;
        lhm.put(3, "vdfve");;
        lhm.put(2, "fggdgb");;
        lhm.put(5, "gmyu");;
        System.out.println(lhm);
        // all methods same as hashmap
    }
}
