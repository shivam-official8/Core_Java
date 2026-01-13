package Day_6.Questions;

import java.util.Arrays;
import java.util.List;

public class CountStringsLongerThen5 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hii", "shivam","hhhhhhhhhhhh", "aaaaaaaaaaaaa", "hjagsuxbwj", "aa");
        System.out.println(list.stream().filter((s)->s.length()>5).count());
    }
}
