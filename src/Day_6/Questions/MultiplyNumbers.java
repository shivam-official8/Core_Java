package Day_6.Questions;

import java.util.Arrays;
import java.util.List;

public class MultiplyNumbers {
    public static void main(String[] args) {
        List<Integer> list =  Arrays.asList(6,5,4,7,8,9,10,11,12,4,2,3,1);
        System.out.println(list.stream().reduce((a,b)->a*b).get());

    }
}
