package Day_4.Exception_handling;

public class Multiple_Catch {
    public static void main(String[] args) {

        // catch blocks should be in order of subclasses -> superclasses
        try {
            String str = null;
            System.out.println(str.length());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic issue");
        } catch (NullPointerException e) {
            System.out.println("Null Pointer exception occurred");
        } catch (Exception e) {
            System.out.println("Some other exception");
        }

        try {
            int[] arr = new int[5];
            arr[10] = 100; // ArrayIndexOutOfBoundsException
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e);
        }


    }
}
