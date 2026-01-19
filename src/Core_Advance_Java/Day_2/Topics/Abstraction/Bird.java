package Core_Advance_Java.Day_2.Topics.Abstraction;

//Q2: Interface
//
//Create interface Flyable with method fly().
//
//Create class Bird and Plane implementing Flyable.
//
//Add default method land() in the interface and call it from both classes.

 interface Flyable{
    public void  fly();
    private void doing(){
        System.out.println("Doing something");
    }
    default void eating(){
        System.out.println("eating");
    }
     static void main(){
        System.out.println("main");
    }
    private static void main1(){
         System.out.println("main1");
     }

}
public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird flying");
    }
}
class Plane implements Flyable{

    @Override
    public void fly() {
        System.out.println("Plane flying");
    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();
        Plane plane = new Plane();
        plane.fly();
        bird.eating();
        Flyable.main();
    }
}
