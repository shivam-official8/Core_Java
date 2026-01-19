package Core_Advance_Java.Day_2.Topics.Attributes_and_Methods;

public class Rectangle {
    public int length;
    public int breadth;
    public int claculateArea(){
        return length*breadth;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.length = 6;
        rectangle.breadth =2;
        System.out.println("Area: "+rectangle.claculateArea());
    }
}
