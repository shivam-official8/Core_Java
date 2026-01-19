package Core_Advance_Java.Day_1.Questions;
import java.util.Scanner;
public class Q_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int a = sc.nextInt();
        System.out.println("a++ : "+(a++));
        System.out.println("a: "+a);
        System.out.println("++a : "+(++a));
        System.out.println("a: "+a);
    }
}
