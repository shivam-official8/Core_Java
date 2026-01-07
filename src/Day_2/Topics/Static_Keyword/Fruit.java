package Day_2.Topics.Static_Keyword;

// Create a class with a static variable that counts how many objects are created.
public class Fruit {
    public static int cnt;

    public Fruit(){
        cnt++;
    }
    public static void main(String[] args) {
        Fruit fruit1 = new Fruit();
        System.out.println(Fruit.cnt);
        Fruit fruit2 = new Fruit();
        System.out.println(Fruit.cnt);
        Fruit fruit3 = new Fruit();
        System.out.println(Fruit.cnt);
        Fruit fruit4 = new Fruit();
        System.out.println(Fruit.cnt);
    }
}
