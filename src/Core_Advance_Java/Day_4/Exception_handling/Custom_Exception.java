package Core_Advance_Java.Day_4.Exception_handling;

import java.io.FileReader;
import java.io.IOException;

class MyException extends Exception {
        MyException(String message) {
            super(message);
        }
}
public class Custom_Exception {
    public static void test(int num) throws MyException {
            if (num < 0) throw new MyException("Negative number not allowed!");
    }
    public static void main(String[] args) {
        try {
                test(-5);
        } catch (MyException e) {
                System.out.println(e.getMessage());
        }

        try (FileReader fr = new FileReader("file.txt")) {
            // read file
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }

    }
}
