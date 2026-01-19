package Core_Advance_Java.Day_6.Questions;

import java.util.function.Predicate;

public class CheckEven {
    public static void main(String[] args) {
        Predicate<Integer> isEven = a->a%2==0;
        System.out.println(isEven.test(19));
        System.out.println(isEven.test(32));
    }
}
