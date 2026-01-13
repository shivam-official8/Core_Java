package Day_6.Questions;

import java.util.function.Function;

interface Stringlen{
    int stringLength(String s);;
}
public class StringLength {
    public static void main(String[] args) {
        Stringlen strlen = (a)->a.length();
        System.out.println(strlen.stringLength("hello"));
        System.out.println(strlen.stringLength("hii"));

        Function<String , Integer> fun = (s)->s.length();
        System.out.println(fun.apply("hey"));
    }
}
