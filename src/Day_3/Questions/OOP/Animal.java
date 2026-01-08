package Day_3.Questions.OOP;
// 🔹 Question 1 — Protected vs Default
//
//Create an abstract class Animal:
//
//protected abstract void sound();
//
//void sleep() prints "Sleeping..."
//
//Create a subclass Dog and override sound().
//In main(), call both methods using Animal reference.


public abstract class Animal {
    protected abstract void sound();
    public void sleep(){
        System.out.println("sleeping");

    }

}
class Dog extends Animal{
    public void sound(){
        System.out.println("bark...");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal animal = new Dog();
        animal.sound();
        animal.sleep();
    }
}
