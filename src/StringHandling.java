public class StringHandling {
    public static void main(String[] args) {
        String a = "heLlo";
        String b = "hellO";
        String s = "Hello java Developer";
        String sObj = new String("hello");
        StringBuilder sb = new StringBuilder(s);
        StringBuffer sbf = new StringBuffer(s);
        System.out.println(a.length());
        System.out.println(a.toUpperCase());
        System.out.println(a.toLowerCase());
        System.out.println(a.charAt(0));
        System.out.println(a.replace("o", "O"));
        System.out.println(a);
        System.out.println(a.equalsIgnoreCase(b));
        String s1 = "hello", s2 = "hello";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s3==s4);
        System.out.println(s3.equals(s4));
        char[] c = s1.toCharArray();
        System.out.println(c.toString());
        System.out.println(sb.reverse());
        System.out.println(s1.substring(1));
        System.out.println("sb 1: "+sb.deleteCharAt(1));
        System.out.println("sb 2: "+sb);
        sb.setCharAt(1, 'o');
        System.out.println(sb);
        System.out.println(sb.length());

    }
}
