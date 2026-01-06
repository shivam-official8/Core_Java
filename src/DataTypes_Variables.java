import java.util.Arrays;

public class DataTypes_Variables {
    public static void main(String[] args) {

        //primitive datatypes
        int a = 10;
        byte b = 15;
        long c = 16L;
        char c1 = 'a';
        float f = 1.23f;
        double d = 23.234;
        short s = 234;

        System.out.println("s: "+s);
        System.out.println("a: "+a);
        System.out.println("b: "+b);
        System.out.println("c: "+c);
        System.out.println("c1: "+c1);
        System.out.println("f: "+f);
        System.out.println("d: "+d);

        //non-primitive datatypes
        int[] arr =new int[10];
        arr[0]=1;
        arr[3]=56;
        arr[2]=23;
        System.out.println(Arrays.toString(arr));

        String st="hello java developer";
        System.out.println(st);

        // var:- it let compiler decide datatype of variable and it should be initialized while declaration
        var x = "123"; // cant be used in instance level and also not in parameters for method or constructor
        var x1 = 123;
        var x2 = 23.34;
        System.out.println(x);
        System.out.println(x1);
        System.out.println(x2);


    }
}
