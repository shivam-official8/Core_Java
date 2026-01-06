package Questions;
import java.util.Scanner;
public class Q_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Name: ");
        String name = sc.nextLine();
        System.out.println();
        System.out.print("Enter Your Age: ");
        int age = sc.nextInt();
        System.out.println();
        System.out.print("Enter Your Salary: ");
        double salary = sc.nextDouble();
        System.out.println("Name: "+name+", Age: "+age+", Salary: "+salary);
    }
}
