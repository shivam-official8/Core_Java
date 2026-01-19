package Core_Advance_Java.Day_4.Collection_Framework_Questions.Maps;

import java.util.HashMap;
import java.util.Scanner;

public class Word_Frequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Sentence: ");
        String s = sc.nextLine();
        HashMap<String, Integer> hm = new HashMap<>();
        String[] sarr = s.split("\\s+");
        for(String s1:sarr){
            hm.put(s1, hm.getOrDefault(s1,0)+1);
        }
        System.out.println(hm);
    }
}
