package Day_1.Questions;

import java.util.Scanner;

public class Q_20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.println();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.println();
        System.out.print("Enter City: ");
        String city = sc.next();
        System.out.printf("\n%-10s %-5s %10s\n", "Name", "Age", "City");
        System.out.printf("%-10s %-5d %10s\n", name, age, city);
    }
}
