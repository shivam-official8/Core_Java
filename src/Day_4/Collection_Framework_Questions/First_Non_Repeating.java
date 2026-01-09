package Day_4.Collection_Framework_Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class First_Non_Repeating {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();
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
        for(int n:arr)
            hm.put(n, hm.getOrDefault(n,0)+1);
        for(int key:hm.keySet()){
            if(hm.get(key)==1){ System.out.println(key);
                break;
            }
        }

    }
}
