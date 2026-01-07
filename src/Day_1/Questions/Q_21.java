package Day_1.Questions;

public class Q_21 {
    public static void main(String[] args) {
        String s1 = "Shivam", s2 = "Shivam";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        String s3 = new String("Shivam");
        String s4 = new String("Shivam");
        System.out.println(s3==s4);
        System.out.println(s3.equals(s4));

    }
}
