package Questions;

import java.util.Scanner;

public class Q_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Dividend: ");
        int dividend  = sc.nextInt();
        System.out.println();
        System.out.println("Enter Divisor: ");
        int divisor = sc.nextInt();
        System.out.println("Quotient: "+(dividend/divisor)+", Remainder: "+(dividend%divisor));
    }
}
