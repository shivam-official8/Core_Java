package Questions;

import java.util.Scanner;

public class Q_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter true/false: ");
        boolean b = sc.nextBoolean();
        System.out.println("&& true: "+(b && true));
        System.out.println("&& false: "+(b && false));
        System.out.println("|| true: "+(b || true));
        System.out.println("|| false: "+(b || false));
    }
}
