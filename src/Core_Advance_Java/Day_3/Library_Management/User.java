package Core_Advance_Java.Day_3.Library_Management;

import java.util.ArrayList;

class BorrowLimitReachedException extends Exception{
    public BorrowLimitReachedException(String msg){
        super(msg);
    }
}

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

    public static void main(String[] args) {
        Library lib = new Library("Central Library");

        Book b1 = new Book(101, "Java Basics", "Author A");
        Book b2 = new Book(102, "OOP Concepts", "Author B");

        lib.addBook(b1);
        lib.addBook(b2);

        Student s1 = new Student(1, "Alice");
        lib.addUser(s1);

        s1.borrowBook(b1);
        s1.borrowBook(b2);
        s1.returnBook(b1);
        for(Book book:s1.getBorrowedBooks()){
            System.out.println(book.toString());
        }

        Borrowable.showRules();
    }

}
class Student extends User implements Borrowable{
    private ArrayList<Book> borrowedBooks = new ArrayList<>();
    private static final int maxBooks = 3;

    public Student(int userId, String name){
        super.userId = userId;
        super.name = name;
    }
    public ArrayList<Book> getBorrowedBooks(){
        return this.borrowedBooks;
    }
    public double calculateFine(int lateDays){
        if(isOverdue(lateDays))
        return 50*lateDays;
        return 0.0;
    }
    public boolean canBorrow(){
        return maxBooks < 3;

    }
    @Override
    public void borrowBook(Book book) {
        try{
            if(borrowedBooks.size() >= maxBooks)
                throw new BorrowLimitReachedException("Borrow limit reached!");
            else if (  !book.isIssued()) {
                borrowedBooks.add(book);
                book.setIssued(true);
                incrementBorrowedCount();
                System.out.println(borrowedBooks);
                System.out.println(this.name + " borrowed " + book.getTitle());
            } else {
                System.out.println("Cannot borrow book: Limit reached or book already issued");
            }
        }
        catch(BorrowLimitReachedException e){
            System.out.println(e.getMessage());
        }

    }
    @Override
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setIssued(false);
            decrementBorrowedCount();
            System.out.println(this.name + " returned " + book.getTitle());
        }
    }
}

class Librarian extends User implements Borrowable{
    private static final int maxBooks = 10;
    private String libraryName;
    private ArrayList<Book> borrowedBooks;
    private ArrayList<Book> managedBooks;
    private ArrayList<User> users;


    public Librarian(int userId, String name){
        super.userId = userId;
        super.name = name;
    }

    public double calculateFine(int lateDays){
        if(isOverdue(lateDays))
            return 50*lateDays;
        return 0.0;
    }
    public boolean canBorrow(){
        return maxBooks < 10;

    }
    @Override
    public void borrowBook(Book book) {
        if (borrowedBooks.size() < maxBooks && !book.isIssued()) {
            borrowedBooks.add(book);
            book.setIssued(true);
            incrementBorrowedCount();
            System.out.println(this.name + " borrowed " + book.getTitle());
        } else {
            System.out.println("Cannot borrow book: Limit reached or book already issued");
        }
    }
    @Override
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setIssued(false);
            decrementBorrowedCount();
            System.out.println(this.name + " returned " + book.getTitle());
        }
    }


}
class Book{
    private int bookId;
    private String title;
    private String author;
    private boolean issued = false;

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
    public void setIssued(boolean issued){
        this.issued = issued;
    }
    public boolean isIssued(){
        return issued;
    }
    public void displayBook(){
        System.out.println("Title: "+this.title+" Author: "+this.author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", issued=" + issued +
                '}';
    }
}

class Library{
    private String libraryName;
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library(String libraryName){
        this.libraryName = libraryName;
    }

    public void addBook(Book book) {
        if (books == null) books = new ArrayList<>();
        books.add(book);
    }

    public void addUser(User user) {
        if (users == null) users = new ArrayList<>();
        users.add(user);
    }

    public void displayBooks() {
        if (books != null) {
            for (Book b : books) b.displayBook();
        }
    }

    public void displayUsers() {
        if (users != null) {
            for (User u : users) u.displayUser();
        }
    }

}

