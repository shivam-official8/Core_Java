package Questions;
import java.util.Scanner;
public class Q_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number 1: ");
        double num1 = sc.nextDouble();
        System.out.println();
        System.out.print("Enter Number 2: ");
        double num2 = sc.nextDouble();
        System.out.println("Addition: " + (num1 + num2));
        System.out.println("Subtraction: " + (num1 - num2));
        System.out.println("Multiplication: " + (num1 * num2));
        System.out.println("Division: " + (num1 / num2));
        System.out.println("Modulo: " + (num1 % num2));
    }
}
