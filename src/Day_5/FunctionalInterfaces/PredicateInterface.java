package Day_5.FunctionalInterfaces;

import java.util.function.Predicate;

public class PredicateInterface {
    public static void main(String[] args) {
        Predicate<Integer> pred = n -> n>0;
        System.out.println(pred.test(-1));
        System.out.println(pred.test(0));
        System.out.println(pred.test(10));
    }
}
