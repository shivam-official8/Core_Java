package Core_Advance_Java.Day_4.Collection_Framework_Questions.Maps;

import java.util.concurrent.ConcurrentHashMap;

public class Remove_Entries {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> hm= new ConcurrentHashMap<>();
        hm.put("ab", 89);
        hm.put("ba", 234);
        hm.put("fb", -24);
        hm.put("hj", 23);
        hm.put("sdf", 11);
        for(String s:hm.keySet()){
            if(hm.get(s)<50)hm.remove(s);
        }
        System.out.println(hm);
    }
}
