package Core_Advance_Java.Day_6.Questions;

import java.util.Arrays;
import java.util.List;

public class SortList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,-1,-90,892,6);
        System.out.println(list);
        list.sort((a,b)->a-b);
        System.out.println(list);
        list.sort((a,b)->b-a);
        System.out.println(list);
    }
}
