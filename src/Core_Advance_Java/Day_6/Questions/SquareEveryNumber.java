package Core_Advance_Java.Day_6.Questions;

import java.util.Arrays;
import java.util.List;

public class SquareEveryNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(list.stream().map((a)->a*a).toList());
    }
}
