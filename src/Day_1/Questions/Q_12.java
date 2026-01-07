package Day_1.Questions;

import java.util.HashSet;
import java.util.Scanner;


public class Q_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');hs.add('e');hs.add('i');hs.add('o');hs.add('u');hs.add('A');hs.add('E');hs.add('I');hs.add('O');
        hs.add('U');
        System.out.print("Enter Character: ");
        char c = sc.next().charAt(0);
        System.out.println(hs.contains(c)? "Vowel" : "Consonant");
    }
}
