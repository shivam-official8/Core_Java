package Day_1.Questions;

import java.util.Scanner;


public class Q_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Integer: ");
        int integer = sc.nextInt();
        System.out.println("Int -> Double: "+((double)(integer)));
        System.out.print("Enter Double: ");
        double db = sc.nextDouble();
        System.out.println("Double -> Int: "+((int)(db)));
    }
}
