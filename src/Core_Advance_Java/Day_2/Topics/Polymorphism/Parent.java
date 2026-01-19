package Core_Advance_Java.Day_2.Topics.Polymorphism;
// 3️⃣ Polymorphism in a Real-World Scenario
//
//Problem:
//
//Abstract class Employee with abstract method calculateSalary().
//
//Subclasses: Manager, Developer, Tester, each implementing calculateSalary().
//
//In main:
//
//Create an array of Employee objects (different subclasses).
//
//Iterate over the array and call calculateSalary() for each.
//
//Print total salary of all employees

public class Parent {
    public void display(){
        System.out.println("Parent display");
    }
}
class Child extends Parent{
    @Override
    public void display() {
        System.out.println("Child display");
    }
    public void childOnlyMethod(){
        System.out.println("Child only");
    }

    public static void main(String[] args) {
        Parent p =new Child();
        p.display();
        if(p instanceof Child){
            ((Child)p).childOnlyMethod();
        }

        System.out.println(p instanceof Parent);
    }
}
