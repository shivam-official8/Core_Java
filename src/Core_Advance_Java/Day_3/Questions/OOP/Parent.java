package Core_Advance_Java.Day_3.Questions.OOP;
// 🔹 Question 3 — Static hiding vs instance method overriding
//
//Create abstract class Parent:
//
//static method show() prints "Parent static"
//
//abstract method display()
//
//Create subclass Child:
//
//static method show() prints "Child static"
//
//override display()
//
//Test all combinations of Parent/Child references.


public abstract class Parent {
    public static void show(){
        System.out.println("parent static");
    }
    public abstract void display();
}
class child extends Parent{
    public static void show(){
        System.out.println("child static");
    }
    public void display(){
        System.out.println("child display");
    }

    public static void main(String[] args) {
        Parent p = new child();
        p.display();
        show();
        Parent.show();
        child c = new child();
        c.display();

    }
}
