package Day_3.Library_Management;

import java.util.ArrayList;

interface Borrowable{
    int maxDays = 14;
    void borrowBook(Book book);
    void returnBook(Book book);

    default boolean isOverdue(int days) {
        return days > maxDays;
    }

    static void showRules() {
        System.out.println("Return book within 14 days");
    }
}

public abstract class User {
    protected int userId;
    protected String name;
    protected int borrowedCount;

    public User(){}
    public User(int userId, String name){
        this.userId = userId;
        this.name = name;

    }
    abstract double calculateFine(int lateDays);

    public void displayUser(){
        System.out.println("Name: "+this.name);
        System.out.println("UserId: "+this.userId);
        System.out.println("BorrowedCount: "+this.borrowedCount);
    }

    public int getBorrowedCount(){
        return borrowedCount;
    }
    public void incrementBorrowedCount(){
        this.borrowedCount++;
    }
    public void decrementBorrowedCount(){
        this.borrowedCount--;
    }
}
class Student extends User{
    private static final int maxBooks = 3;

    public Student(int userId, String name){
        super.userId = userId;
        super.name = name;
    }
    public double calculateFine(int lateDays){
        return 100*lateDays;
    }
    public boolean canBorrow(){
        return maxBooks < 3;

    }
}

class Librarian extends User{
    private static final int maxBooks = 10;
    private String libraryName;
    private ArrayList<Book> books;
    private ArrayList<User> users;


    public Librarian(int userId, String name){
        super.userId = userId;
        super.name = name;
    }
    public double calculateFine(int lateDays){
        return 50*lateDays;
    }
    public boolean canBorrow(){
        return maxBooks < 10;

    }


}
class Book{
    private int bookId;
    private String title;
    private String author;
    private boolean issued;

    public Book(int bookId, String title, String author){
        this.author = author;
        this.title = title;
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

