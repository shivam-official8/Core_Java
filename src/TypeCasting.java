public class TypeCasting {
    public static void main(String[] args) {
        int a = 10;
        int b1=3;
        long b = a;
        long c = 188999;
        int l = (int)(c);
        char cr = '3';
        int cr1 = cr-'0';
        System.out.println(cr1 +1);
        char cr2 = 'a';
        int cr3 = (int)(cr2);
        System.out.println(cr3);
        double d = (double)a/b1;
        System.out.println(d);
        String s = a+"";
        String s1 = String.valueOf(s);

    }
}
