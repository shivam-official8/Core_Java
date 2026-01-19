package Core_Advance_Java.Day_1.Topics;

public class Methods_Constructors {
    public int a = 10;
    public int b = 20;

    public Methods_Constructors(){

    }
    // constructor overloading
    public Methods_Constructors(int a){

        System.out.println(a);
    }
    public void add(){
        System.out.println(a+b);
    }
    // method overloading and changing return type doesnt count in overloading
    public void add(int a, int b){
        System.out.println(a+b);
    }
    public static void main(String[] args) {

    }
}
