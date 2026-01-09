package Day_4.Collection_Framework_Questions.Maps;

import java.util.HashMap;
import java.util.Scanner;

public class Employees {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "shivam");
        hm.put(2, "dev");
        hm.put(3, "tushar");
        hm.put(4, "john");
        hm.put(5, "hello");
        hm.put(6, "summer");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employeeId to find: ");
        int id = sc.nextInt();
        if(hm.containsKey(id))
        System.out.println("Id: "+id+" Name: "+hm.get(id));
        else System.out.println("No Id Match!");
    }
}
