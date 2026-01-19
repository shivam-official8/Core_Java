package Core_Advance_Java.Day_2.Topics.Inheritance;

// Q3: Hierarchical Inheritance
//
//Class Shape → method area()
//
//Classes Circle and Rectangle extend Shape
//
//Override area() in both subclasses and display results.

public class Shape {
    public void area(int a, int b){
        System.out.println("area for sides a="+a+", b="+b);
    }
}

class rectangle extends Shape{
    @Override
    public void area(int a, int b) {
        super.area(a, b);
        System.out.println("Rectangle: "+(a*b));
    }
}
class square extends Shape{
    @Override
    public void area(int a, int b) {
        super.area(a, b);
        System.out.println("Square: "+(a*a));
    }

    public static void main(String[] args) {
        rectangle rec= new rectangle();
        rec.area(2,3);
        square sq = new square();
        sq.area(2,2);
    }
}
