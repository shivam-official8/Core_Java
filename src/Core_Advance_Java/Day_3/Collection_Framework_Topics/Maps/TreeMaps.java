package Core_Advance_Java.Day_3.Collection_Framework_Topics.Maps;

import java.util.Iterator;
import java.util.TreeMap;

public class TreeMaps {
    public static void main(String[] args) {
        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(1,"hii 1");
        tm.put(2,"hii 2");
        tm.put(3,"hii 3");
        tm.put(4,"hii 4");
        tm.put(5,"hii 5");

        Iterator<Integer> iterator = tm.keySet().iterator();

        while(iterator.hasNext()){
            System.out.println(tm.get(iterator.next()));
        }
        Iterator<Integer> iterator1 = tm.descendingKeySet().iterator();

        while(iterator1.hasNext()){
            System.out.println(tm.get(iterator1.next()));
        }
        System.out.println(tm.firstKey());
        System.out.println(tm.lastKey());
        System.out.println(tm.headMap(3));
        System.out.println(tm.tailMap(3));
        System.out.println(tm.subMap(2,5));


    }

}
