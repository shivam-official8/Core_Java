package Core_Advance_Java.Day_2.Topics.Inheritance;

// Q1: Single Inheritance
//
//Create a class Animal with method eat().
//
//Create subclass Dog that inherits Animal and adds method bark().
//
//Test both methods in main.

public class Animal {
    public void eat(){
        System.out.println("eating");
    }
}
class Dog extends Animal{
    public void bark(){
        System.out.println("barking");
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        animal.eat();
        dog.bark();
        dog.eat();

    }
}
