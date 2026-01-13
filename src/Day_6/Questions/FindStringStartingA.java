package Day_6.Questions;

import java.util.Arrays;
import java.util.List;

public class FindStringStartingA {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hii","AV","AAAA","yo","Are","shivam");
        System.out.println(list.stream().filter((s)->s.startsWith("A")).toList());
    }
}
