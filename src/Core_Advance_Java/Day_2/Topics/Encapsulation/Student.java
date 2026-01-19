package Core_Advance_Java.Day_2.Topics.Encapsulation;
// Q1: Read-only Property
//
//Create class Student with final private int rollNo.
//
//Only provide getter, no setter.
//
//Show that rollNo cannot be modified.
public class Student {
    final private int rollno=19;

    public int getRollno() {
        return rollno;
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.getRollno();
    }
}

