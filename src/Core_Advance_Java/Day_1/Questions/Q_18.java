package Core_Advance_Java.Day_1.Questions;

import java.util.Scanner;

public class Q_18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Celsius: ");
        double celsius = sc.nextDouble();
        System.out.println("Fahrenheit: "+(((9/5d)*celsius)+32));
    }
}
