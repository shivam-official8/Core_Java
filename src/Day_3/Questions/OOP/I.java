package Day_3.Questions.OOP;
// 🔹 Question 7 — Private method illusion
//
//Create interface I:
//
//default method call() calls private method helper() printing "I helper"
//
//Create class C implementing I with its own private helper() printing "C helper"
//
//Call call() in main().
//Observe which helper executes


public interface I {
    default void call(){
        helper();
    }
    private void helper(){
        System.out.println("Helper");
    }
}
class c implements  I{
    private void helper(){
        System.out.println(" c Helper");
    }

    public static void main(String[] args) {
        I i = new c();
        i.call();
    }
}
