package Core_Advance_Java.Day_4.Collection_Framework_Questions.Lists;

import java.util.ArrayList;
import java.util.HashSet;

public class Unique_numbers {
    public static void main(String[] args) {

        // we can also do this by sorting the list
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
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
        System.out.println(arr);

//        while(!arr.isEmpty()){
//            int n = arr.get(i);
//        }
//        for(int i=arr.size()-1;i>=0;i--){
//            int n = arr.get(i);
//            if(hs.contains(n))arr.remove(i);
//            else hs.add(n);
//        }
//        System.out.println(arr);

        // by sorting list
        arr.sort((a,b)->a-b);
        int i = 0;
        while(i<arr.size()-1){
            if(arr.get(i)==arr.get(i+1))arr.remove(i+1);
            else i++;
        }
        System.out.println(arr);
    }
}
