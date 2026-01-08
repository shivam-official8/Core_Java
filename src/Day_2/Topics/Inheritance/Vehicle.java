package Day_2.Topics.Inheritance;

public class Vehicle {
    public void start(){
        System.out.println("starting");
    }
}
class Car extends Vehicle{
    public void fuel(){
        System.out.println("fueling");
    }
}
class ElectricCar extends Car{
    public void charge(){
        System.out.println("charging");
    }

    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.start();
        electricCar.fuel();
        electricCar.charge();
    }
}

