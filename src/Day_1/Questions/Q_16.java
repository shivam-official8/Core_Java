package Day_1.Questions;

import java.util.Scanner;

public class Q_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Slary: ");
        double salary = sc.nextDouble();
        double salary_bonus = salary*0.5;
        System.out.println("Salary Bonus: "+salary_bonus);

    }
}
