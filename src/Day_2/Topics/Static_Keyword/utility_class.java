package Day_2.Topics.Static_Keyword;
// Create a utility class with a static method add(int a, int b) and call it without creating an object.
public class utility_class {
    public static int add(int  num1, int num2){
        return num1+num2;
    }

    public static void main(String[] args) {
        System.out.println(add(3,4));
    }
}
