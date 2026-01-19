package Core_Advance_Java.Day_3.Questions.OOP;
// 🔹 Question 6 — Default method conflict
//
//Create interface A and B:
//
//Both have default void show() printing "A" or "B"
//
//Create abstract class C implementing both interfaces,
//Create concrete class D extending C.
//
//Call show() in main().

interface A {
    default void show(){
        System.out.println("A");
    }
}
interface B{
    default void show(){
        System.out.println("B");
    }
}
//public abstract class C implements A,B {
//    // it doesnt know which show method to override so gives ce
//
//}
//class D extends C{
//
//
//}
