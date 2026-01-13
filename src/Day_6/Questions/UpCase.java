package Day_6.Questions;

import java.util.function.Function;

interface uppercase{
    String transform(String s);
}

public class UpCase {
    public static void main(String[] args) {
        Function<String, String> fun = (s)->s.toUpperCase();
        System.out.println(fun.apply("shivam"));

        uppercase up  = (s)->s.toUpperCase();
        System.out.println(up.transform("hello"));
    }
}
