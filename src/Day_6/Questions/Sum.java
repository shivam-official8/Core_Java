package Day_6.Questions;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

interface Add{
    int addition(int a, int b);
}

public class Sum {
    public static void main(String[] args) {
        // 1st approach
        Add add = (a,b)->a+b;
        System.out.println(add.addition(36,97));
        // 2nd approach
        BiFunction<Integer, Integer, Integer> sum = (a,b)->a+b;
        System.out.println(sum.apply(2,4));
        // 3rd
        BinaryOperator<Integer> sum1 = (a,b)->a+b;

    }
}
