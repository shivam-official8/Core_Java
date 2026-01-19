package Core_Advance_Java.Day_5.FunctionalInterfaces;

import java.util.function.Consumer;

public class ConsumerInterface {
    public static void main(String[] args) {
        Consumer<String> con = (s) -> System.out.println("1. "+s);
        Consumer<String> con1 = (s) -> System.out.println("2. "+s);
        con.andThen(con1).accept("hello");
    }
}
