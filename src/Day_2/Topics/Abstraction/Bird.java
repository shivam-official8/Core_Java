package Day_2.Topics.Abstraction;

//Q2: Interface
//
//Create interface Flyable with method fly().
//
//Create class Bird and Plane implementing Flyable.
//
//Add default method land() in the interface and call it from both classes.

 interface Flyable{
    public void  fly();
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
    }
}
