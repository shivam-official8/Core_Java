package Day_2.Topics.Polymorphism;
// 1️⃣ Basic Polymorphism
//
//Problem:
//
//Create a parent class Animal with method makeSound().
//
//Create subclasses Dog and Cat overriding makeSound().
//
//In main, create an array of Animal containing Dog and Cat.
//
//Call makeSound() on each element.

public class Animal {
    public void makeSound(){
        System.out.println("Animal sound");
    }
}
class Dog extends Animal{
    @Override
    public void makeSound() {
        System.out.println("Barking...");
    }
}
class Cat extends Animal{
    @Override
    public void makeSound() {
        System.out.println("Meow...");
    }

    public static void main(String[] args) {
        Animal[] animals={new Dog(), new Cat()};
        for (Animal animal : animals){
            Animal a = animal; // Dynamic method dispatch (DMD)
            a.makeSound();
        }
    }
}
