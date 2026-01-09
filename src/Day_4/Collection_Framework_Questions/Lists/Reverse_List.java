package Day_4.Collection_Framework_Questions.Lists;

import java.util.ArrayList;

public class Reverse_List {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(2);
        arr.add(2);
        arr.add(28);
        arr.add(99);
        arr.add(100);
        arr.add(100);
        System.out.println(arr);
        int i = 0, j = arr.size()-1;
        while(i<=j){
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }
        System.out.println(arr);
    }
}
