package Core_Advance_Java.Day_3.Collection_Framework_Topics;

import java.util.Arrays;
import java.util.List;

public class Streams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 3, 6);
        List<Integer> evenSquares = numbers.stream().filter(n->n%2==0).toList();
        List<Integer> ans = evenSquares.stream().map(n->n*n).toList();
        System.out.println(ans);
        List<Integer> sorted = numbers.stream().sorted().toList();
        System.out.println(sorted);
        List<Integer> distinct = numbers.stream().distinct().toList();
        System.out.println(distinct);
        List<Integer> limit = numbers.stream().limit(3).toList();
        System.out.println(limit);
        List<Integer> skip = numbers.stream().skip(3).toList();
        System.out.println(skip);
        int sum = numbers.stream().filter(n->n%2==0).mapToInt(n->n).sum();
        System.out.println(sum);
        long cnt = numbers.stream().filter(n->n%2==0).mapToInt(n->n).count();
        System.out.println(cnt);
        int red = numbers.stream().reduce((a,b)->a+b).orElse(0);
        System.out.println(red);


    }
}
