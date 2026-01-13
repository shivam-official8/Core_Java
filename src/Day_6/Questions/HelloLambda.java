package Day_6.Questions;

public class HelloLambda {
    public static void main(String[] args) {
        Runnable run = ()-> System.out.println("Hello Lambda");
        run.run();
    }
}
