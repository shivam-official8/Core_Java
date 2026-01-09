package Day_4.Collection_Framework_Questions.Maps;

import java.util.HashMap;

public class Key_Max_value {
    public static void main(String[] args) {
        HashMap<String, Integer> hm= new HashMap<>();
        hm.put("ab", 89);
        hm.put("ba", 234);
        hm.put("fb", -24);
        hm.put("hj", 23);
        hm.put("sdf", 11);
        int max = Integer.MIN_VALUE;
        String ans="";
        for(String s:hm.keySet()){
            int val = hm.get(s);
            if(val>max)
            max=val;
            ans=s;
        }
        System.out.println(ans);
    }
}
