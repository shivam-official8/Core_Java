package Questions;

import java.util.Scanner;

public class Q_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number 1: ");
        int num1 = sc.nextInt();
        System.out.print("Enter Number 2: ");
        int num2 = sc.nextInt();
        num1 += num2;
        num2 = num1-num2;
        num1 -= num2;
        System.out.println("Number 1: "+num1);
        System.out.println("Number 2: "+num2);

    }
}
