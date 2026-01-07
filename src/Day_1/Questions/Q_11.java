package Day_1.Questions;

import java.util.Scanner;


public class Q_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Radius: ");
        double radius = sc.nextDouble();
        System.out.println("Area of Circle: "+(Math.PI * Math.pow(radius, 2)));
    }
}
