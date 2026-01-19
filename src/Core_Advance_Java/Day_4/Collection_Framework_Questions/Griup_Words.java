package Core_Advance_Java.Day_4.Collection_Framework_Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Griup_Words {
    public static void main(String[] args) {
        String[] words = {"abc", "sd", "ar", "dr","dgf", "bb", "bca"};
        HashMap<Character, List<String>> hm = new HashMap<>();
        for(String s:words){
            if(!hm.containsKey(s.charAt(0))){hm.put(s.charAt(0), new ArrayList<>());
            }
                hm.get(s.charAt(0)).add(s);
        }
        System.out.println(hm);

    }
}
