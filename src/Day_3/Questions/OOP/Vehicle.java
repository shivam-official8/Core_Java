package Day_3.Questions.OOP;
interface speedlimit{
    int max = 60; // public static final
//      default void main(){
//
//    }
}

public abstract class Vehicle {
    protected int speed = 100;
}
class car extends Vehicle{
    int speed = 120;
    public void display(){
        System.out.println(this.speed);
        System.out.println(super.speed);
        System.out.println(speedlimit.max);
    }

    public static void main(String[] args) {
        car c = new car();
        c.display();
    }
}

