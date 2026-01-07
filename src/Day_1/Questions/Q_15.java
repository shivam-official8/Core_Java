package Day_1.Questions;

import java.util.Scanner;


public class Q_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Enter your Age: ");
        int age = sc.nextInt();
        System.out.println(age>=18?"Eligible":"Not-Eligible");

    }
}
