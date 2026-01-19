package Core_Advance_Java.Day_2.Topics.Classes_and_Objects;
//Q1: Define a class Car with attributes make, name and year. Create an object of the class and print its attributes.

public class Car {
    String carName;
    public String maker;
    public int year;

    public Car(String maker, String carName, int year){
        this.maker = maker;
        this.carName = carName;
        this.year = year;
    }

    public static void main(String[] args) {
        Car car = new Car("Hyundai", "i20", 2011);
        System.out.println("Car Maker: "+car.maker+", Car Name: "+ car.carName+", Model year: "+car.year);
    }
}
