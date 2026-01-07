package Day_2.Topics.NestedClasses;

public class Outer {
    public int count = 0;
    public static int count1 = 100;
    private int pass = 1234;
    public class Inner{
        public void show(){
            System.out.println(++count);
            System.out.println(pass);
        }
    }

    public static class Inner2{
        public void show(){
            System.out.println(++count1);
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.show();
        Outer.Inner2 inner2 = new Outer.Inner2();
        inner2.show();

    }
}
