package Core_Advance_Java.Day_3.Questions.OOP;
interface X{
    default void m(){
        System.out.println("X");
    }
}

public abstract class Y {
    protected abstract void m();
}

class Z extends Y implements X{
    public void m(){
        System.out.println("Z");
    }

    public static void main(String[] args) {
        X x = new Z();
        Y y = new Z();
        Z z = new Z();
        x.m();
        y.m();
        z.m();
    }
}
