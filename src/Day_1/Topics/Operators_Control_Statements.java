package Day_1.Topics;

public class Operators_Control_Statements {
    public static void main(String[] args) {
        // arithmetic operators
        int a = 4, b = 2;
        boolean b1 = true, b2 = false;
        System.out.println("a + b: "+(a+b));
        System.out.println("a - b: "+(a-b));
        System.out.println("a / b: "+(a/b));
        System.out.println("a * b: "+(a*b));
        System.out.println("a % b: "+(a%b));

        // logical operator
        System.out.println("! (NOT): "+(a!=b));
        System.out.println("! (NOT): "+(b1!=b2));
        System.out.println("&& (AND): "+(b1 && b2));
        System.out.println("|| (OR): "+(b1 || b2));

        // unary operator
        System.out.println(a++);
        System.out.println(a);
        System.out.println(b);
        System.out.println(++b);

        // ternary operator
        String s = a>b ? "yes":"no";
        System.out.println("s; "+s);

        // assignment operator
        a+=1;
        System.out.println("a+=1: "+a);
        b-=1;
        System.out.println("b-=1: "+b);
        int c = b;
        System.out.println("c: "+c);
        a*=2;
        System.out.println("a*=2: "+a);
        a/=2;
        System.out.println("a/=2: "+a);
        System.out.println("b%=a: "+(b%a));

        // bitwise and shift operators
        System.out.println("a & b (AND): "+(a & b));
        System.out.println("a | b (OR): "+(a | b));
        System.out.println("a ^ b (XOR): "+(a ^ b));
        System.out.println("~(a ^ b) (XNOR): "+(~(a ^ b)));
        System.out.println("~ (compliment): "+(a ^ b));
        System.out.println("a << b (signed left shift): "+(a << b));
        System.out.println("a >> b (signed right shift): "+(a >> b));
        System.out.println("a >>> b (unsigned right shift): "+(a >>> b));

        // control statements
        int i = 10;
        if (i < 15) {
            System.out.println("Condition is True");
        }
        if (i < 15)
            System.out.println("i is smaller than 15");
        else
            System.out.println("i is greater than 15");

        if (i < 15) {
            System.out.println("i is smaller than 15");

            // Nested if statement
            if (i == 10) {
                System.out.println("i is exactly 10");
            }
        }
        if (i == 10)
            System.out.println("i is 10");
        else if (i == 15)
            System.out.println("i is 15");
        else if (i == 20)
            System.out.println("i is 20");
        else
            System.out.println("i is not present");

        // switch case
        int num = 20;
        switch (num) {
            case 5:
                System.out.println("It is 5");
                break;
            case 10:
                System.out.println("It is 10");
                break;
            case 15:
                System.out.println("It is 15");
                break;
            case 20:
                System.out.println("It is 20");
                break;
            default:
                System.out.println("Not present");
        }

        // enhanceed switch case
        switch (num) {
            case 5->
                System.out.println("It is 5");

            case 10->
                System.out.println("It is 10");

            case 15->
                System.out.println("It is 15");

            case 20, 21->
                System.out.println("It is 20");

            default->
                System.out.println("Not present");
        }




    }
}
