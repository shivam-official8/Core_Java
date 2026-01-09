package Day_4.Collection_Framework_Questions.Lists;
import java.util.ArrayList;
import java.util.List;

public class Even_numbers {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(2);
        arr.add(6);
        arr.add(1);
        arr.add(7);
        arr.add(15);
        arr.add(17);
        arr.add(98);
        arr.add(100);
        arr.add(11);
        List<Integer> even = arr.stream().filter(n->n%2==0).toList();
        System.out.println(even);
        even.stream().forEach(n-> System.out.println(n));
        arr.stream().filter(n->n%2==0).forEach(n-> System.out.println(n));


    }
}
