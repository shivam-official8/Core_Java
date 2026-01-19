package Core_Advance_Java.Day_2.Topics.Access_Specifiers;

// Create two classes in the same package and show how default access works.

public class Engineer {
    public static void main(String[] args) {
        Employee employee = new Employee();
        System.out.println(employee.age);
    }
}
