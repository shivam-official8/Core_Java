package Core_Advance_Java.Day_2.Topics.Classes_and_Objects;
//Create a class Student with attributes name and rollNo.
//Create an object and print the values.

public class Student {
    public String name;
    public int rollno;

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "shivam";
        student.rollno = 9;
        System.out.println("Name: "+student.name+", Roll no.: "+student.rollno);
    }
}
