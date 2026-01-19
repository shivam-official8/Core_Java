package Core_Advance_Java.Day_5.LambdaExpression;

import java.util.Arrays;
import java.util.List;

// function interface
// A functional interface has exactly one abstract method. Lambda expressions provide its implementation.
// @FunctionalInterface annotation is optional but recommended to enforce this rule at compile time.
@FunctionalInterface
interface Add{
    int addition(int a, int b);
    default void addition(int a, int b, int c){
        System.out.println(a+b+c);
    }
}
public class LambdaExpression {
    public static void main(String[] args) {
        // functional interface object
        Add add = (x, y) -> x+y;
        int result = add.addition(3,4);
        System.out.println(result);
    }
}


@FunctionalInterface
interface Functional {
    int operation(int a, int b);
}

class Test {

    public static void main(String[] args) {

        // Using lambda expressions to define the operations
        Functional add = (a, b) -> a + b;
        Functional multiply = (a, b) -> a * b;

        // Using the operations
        System.out.println(add.operation(6, 3));
        System.out.println(multiply.operation(4, 5));

        List<String> names = Arrays.asList(
                "Alice", "Bob", "Charlie", "Adam");
        names.stream().filter(n->n.startsWith("A")).map(n->n.toUpperCase()).forEach(System.out::println);
    }
}

// lambda with no param
interface Test1 {
    void print();
}
class NoParam {
    public static void main(String[] args)
    {
     Test1 test1 = ()-> System.out.println("Hello");
     test1.print();
    }
}

// lambda with single param
interface Test2 {
    void print(String s);
}
class SingleParam {
    public static void main(String[] args)
    {
        Test2 test2 = (s)-> System.out.println("Hello "+s);
        test2.print("Java");
    }
}

// lambda with multi param
interface Test3 {
    void print(String s, int a);
}
class MultiParam {
    public static void main(String[] args)
    {
        Test3 test3 = (s, a)-> System.out.println(a+". Hello "+s);
        test3.print("Java", 1);
    }
}