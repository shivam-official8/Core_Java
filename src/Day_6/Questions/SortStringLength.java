package Day_6.Questions;

import java.util.Arrays;
import java.util.List;

public class SortStringLength {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hiiiiieeeeee", "yooo","hi", "shivam", "A");
        list.sort((a,b)->a.length()-b.length());
        System.out.println(list);
        list.sort((a,b)->b.length()-a.length());
        System.out.println(list);
    }
}
