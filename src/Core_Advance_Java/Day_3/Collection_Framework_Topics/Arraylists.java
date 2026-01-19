package Core_Advance_Java.Day_3.Collection_Framework_Topics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arraylists {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>();
        arr.add(23);
        arr.add(45);
        arr.add(28);
        arr.add(67);
        arr.add(69);
        arr1.add(69);
        arr1.add(28);
        arr1.add(67);
        arr1.add(89);
        System.out.println(arr.contains(28));
        System.out.println(arr.containsAll(arr1));
        Object[] arr3 =arr.toArray();
//        arr.retainAll(arr1);
        System.out.println(arr);
        arr1.addAll(arr);
        System.out.println(arr1);
        arr1.add(0,3456);
        System.out.println(arr.indexOf(67));
        System.out.println(arr.lastIndexOf(28));
        arr.remove(Integer.valueOf(67));
        System.out.println(arr);
        Collections.sort(arr, (a, b)->b-a);
        System.out.println(arr);
        arr.sort((a, b) -> a - b);
        System.out.println(arr);


    }
}
