package Core_Advance_Java.Day_4.Exception_handling;

public class Try_catch {
    public static void main(String[] args) {
        try{
            int a = 10/0;
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Error occured in finally!");
        }
    }
}
