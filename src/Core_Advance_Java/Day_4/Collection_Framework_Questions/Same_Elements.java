package Core_Advance_Java.Day_4.Collection_Framework_Questions;

import java.util.ArrayList;

public class Same_Elements {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(1);
        arr1.add(3);
        arr1.add(2);
        arr1.add(5);
        arr2.add(3);
        arr2.add(3);
        arr2.add(1);
        arr2.add(3);
        arr2.add(2);
        arr2.add(5);
        boolean b=false;
        for(int a:arr1){
            if(!arr2.contains(a)){
                System.out.println("No");
                b=true;
                break;
            }
        }
        if(!b) System.out.println("yes");
    }
}
