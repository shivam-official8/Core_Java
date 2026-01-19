package Core_Advance_Java.Day_3.Questions.OOP;
interface Service{
    void execute();
}

public abstract class BaseService implements Service {
 public void execute(){   // protected not works scope is weaker
     System.out.println("dj v");
 }

    public static void main(String[] args) {

    }
}
