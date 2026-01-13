package Day_6.Questions;

import java.util.Arrays;
import java.util.List;

public class FilterEven {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6,5,4,7,8,9,10,11,12,4,2,3,1,0);
        System.out.println(list.stream().filter((a)->a%2==0).toList());
    }
}
