package Day_5.FunctionalInterfaces;

import java.util.function.Supplier;

public class SupplierInterface {
    public static void main(String[] args) {
        Supplier<Double> s = () -> Math.random();
        System.out.println(s.get());

    }
}
