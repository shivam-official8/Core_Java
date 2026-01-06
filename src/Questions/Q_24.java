package Questions;

import java.util.Scanner;

public class Q_24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s.equals(sb.reverse().toString()));
    }
}
