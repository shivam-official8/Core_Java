package Core_Advance_Java.Day_5.FunctionalInterfaces;

import java.util.function.Function;

public class FunctionInterface {
    public static void main(String[] args) {
        Function<Integer, String> f = n -> "Number " + n;
        System.out.println(f.apply(5));

    }
}
