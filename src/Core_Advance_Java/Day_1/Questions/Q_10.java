package Core_Advance_Java.Day_1.Questions;
import java.util.Scanner;

public class Q_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principle: ");
        double principle = sc.nextDouble();
        System.out.println();
        System.out.print("Enter Rate: ");
        double rate = sc.nextDouble();
        System.out.println();
        System.out.print("Enter Time: ");
        double time = sc.nextDouble();
        System.out.println("Simple Interest: "+((principle*rate*time)/100));
    }
}
