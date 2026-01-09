package Day_4.Collection_Framework_Questions.Sets;

import java.util.HashSet;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        HashSet<Integer> hs= new HashSet<>();
        System.out.println("Enter number of Students: ");
        int n = sc.nextInt();
        System.out.println("Enter roll no.'s: ");
        while(n-->0){
            int roll = sc.nextInt();
            hs.add(roll);
        }
        System.out.println(hs);

    }
}
