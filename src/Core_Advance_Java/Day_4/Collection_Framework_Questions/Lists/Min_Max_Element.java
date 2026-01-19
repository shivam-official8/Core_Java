package Core_Advance_Java.Day_4.Collection_Framework_Questions.Lists;

import java.util.ArrayList;

public class Min_Max_Element {
    public static void main(String[] args) {
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
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int n : arr){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        System.out.println(max+" "+min);
    }
}
